package SimpleDB;

import java.util.HashMap;

/**
 * A transaction block conceptually includes all past uncommitted transactions accessible through traversing to the previous transaction block.
 */
class TransactionBlock {
    private TransactionBlock prev;	// point to the immediate past TransactionBlock

    // Delta only. Not the full transaction history.
    private HashMap<String, Integer> name_value = new HashMap<String, Integer>();
    private HashMap<Integer, Integer> value_counter = new HashMap<Integer, Integer>();

    public TransactionBlock(){}

    public void setPrev(TransactionBlock block) {
        prev = block;
    }

    public TransactionBlock(HashMap<String, Integer>nameValue, HashMap<Integer, Integer>valueCounter){
        name_value = nameValue;
        value_counter = valueCounter;
    }

    public HashMap<String, Integer> getNameValue(){
        return name_value;
    }

    // Set the variable name to the value and maintain delta counter.
    public void set(String name, Integer currentValue){

        // maintain delta value_counter, decrease counter of old 'name' value
        Integer prevValue = get(name);
        if (prevValue != null){
            Integer prevValueCounter = numEqualTo(prevValue);
            value_counter.put(prevValue, --prevValueCounter);
        }

        // maintain delta value_counter, increase counter of new 'name' value
        Integer currentValueCounter = numEqualTo(currentValue);
        if (currentValue != null) {
            if (currentValueCounter != null) {
                value_counter.put(currentValue, ++currentValueCounter);
            } else {
                value_counter.put(currentValue, new Integer(1));
            }
        }

        name_value.put(name, currentValue);
    }

    // Get the value for the given name
    public Integer get(String name) {
        TransactionBlock block = this;
        Integer value = block.name_value.get(name);
        while(!block.name_value.containsKey(name) && block.prev != null){
            block = block.prev;
            value = block.name_value.get(name);
        }
        return value;
    }

    // Print out the number of variables that are currently set to value. If no variables equal that value, print 0.
    public Integer numEqualTo(Integer value){
        if (value == null) return 0;

        TransactionBlock block = this;
        Integer counter = block.value_counter.get(value);
        while(counter == null && block.prev != null){
            block = block.prev;
            counter = block.value_counter.get(value);
        }

        if (counter == null)
            return 0;
        else{
            return counter;
        }
    }
}
