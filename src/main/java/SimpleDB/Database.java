package SimpleDB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * A DB contains a sequence of uncommitted Transaction Blocks.
 */
public class Database {
    private LinkedList<TransactionBlock> blocks;

    // Initialize db with an initial transaction block to hold transaction history
    public Database(){
        blocks = new LinkedList<TransactionBlock>();
        blocks.add(new TransactionBlock());
    }

    // Set the variable name to the value.
    public void set(String name, Integer value){
        blocks.getLast().set(name, value);
    }

    // Get the value of the variable name, or NULL if that variable is not set.
    public Integer get(String name){
        return blocks.getLast().get(name);
    }

    // Return the number of variables that are currently set to value. If no variables equal that value, print 0.
    public Integer numEqualTo(Integer value){
        return blocks.getLast().numEqualTo(value);
    }

    // Close all open transaction blocks, permanently applying the changes made in them. Return false if no transaction is in progress.
    @SuppressWarnings("unchecked")
    public boolean commit() {
        if (blocks.size() <= 1) return false;

        HashMap<String, Integer> name_value = new HashMap<String, Integer>();
        HashMap<Integer, Integer> value_counter = new HashMap<Integer, Integer>();

        ListIterator<TransactionBlock> iterator = blocks.listIterator();
        while (iterator.hasNext()) {
            TransactionBlock block = iterator.next();
            name_value.putAll((Map<? extends String, ? extends Integer>) block.getNameValue());
        }

        for (Entry<String, Integer> entry : name_value.entrySet()) {
            Integer value = entry.getValue();
            if(value_counter.get(value) == null){
                value_counter.put(value, new Integer(1));
            }
            else{
                value_counter.put(value, new Integer(value_counter.get(value) + 1));
            }
            name_value.put(entry.getKey(),entry.getValue());
        }

        blocks = new LinkedList<TransactionBlock>();
        blocks.add(new TransactionBlock(name_value, value_counter));

        return true;
    }

    // Undo all of the commands issued in the most recent transaction block, and discard the block. Return false if no previous block to roll back to.
    public boolean rollBack(){
        if (blocks.size() <= 1) return false;
        blocks.removeLast();
        return true;
    }

    // Open a new transaction block.Transaction blocks can be nested; a BEGIN can be issued inside of an existing block.
    public void begin(){
        TransactionBlock block = new TransactionBlock();
        block.setPrev(blocks.getLast());
        blocks.add(block);
    }

    public static void main(String[] args) {
        Database db = new Database();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\s+"); // space delimited
        String cmdLine; // cmdLine is typically 'cmd' followed by 'key' followed by 'value'
        while (scanner.hasNextLine()) {
            cmdLine = scanner.nextLine();
            String[] tokens = cmdLine.split("\\s+");
            String cmd = tokens[0];
            String name;
            Integer value;
            try {
                switch (cmd) {
                    case "GET":
                        name = tokens[1];
                        System.out.println(db.get(name) != null ? db.get(name):"NULL");
                        break;
                    case "SET":
                        name = tokens[1];
                        value = Integer.parseInt(tokens[2]);
                        db.set(name, value);
                        break;
                    case "UNSET":
                        name = tokens[1];
                        db.set(name, null);
                        break;
                    case "NUMEQUALTO":
                        value = Integer.parseInt(tokens[1]);
                        System.out.println(db.numEqualTo(value));
                        break;
                    case "BEGIN":
                        db.begin();
                        break;
                    case "ROLLBACK":
                        if (!db.rollBack()) System.out.println("NO TRANSACTION");
                        break;
                    case "COMMIT":
                        if (!db.commit()) System.out.println("NO TRANSACTION");
                        break;
                    case "END":
                        return;
                    case "":
                        break;
                    default:
                        System.out.println("Invalid command: " + cmd );
                }
            } catch (NumberFormatException e) {			// SET n a
                System.out.println("Invalid number format: " + cmdLine );
            } catch (ArrayIndexOutOfBoundsException e) {// GET
                System.out.println("Possibly missing operand: " + cmdLine );
            }
        }
        scanner.close();
    }
}
