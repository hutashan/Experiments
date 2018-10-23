package s;

import java.util.*;

public class TestPro {
    static HashSet<String> visited = new HashSet<String>();
    static LinkedHashSet<String> install = new LinkedHashSet<String>();
    static HashMap<String, LinkedList<String>> dependencies = new HashMap<String, LinkedList<String>>();
    static HashMap<String, LinkedList<String>> reverseDependencies = new HashMap<String, LinkedList<String>>();

    public static void main(String[] args) {
        String[] arr = {
                "DEPEND TELNET TCPIP NETCARD",
                "DEPEND TCPIP NETCARD",
                "DEPEND NETCARD TCPIP",
                "TCPIP depends on NETCARD, ignoring command",
                "DEPEND DNS TCPIP NETCARD",
                "DEPEND BROWSER TCPIP HTML",
                "INSTALL NETCARD",
                "INSTALL TELNET",
                "INSTALL foo" ,
                "INSTALL BROWSER" ,
                "REMOVE NETCARD",
                "REMOVE BROWSER",
                "LIST"
            };
        doIt(arr);
    }




    static void doIt(String[] input) {

       for (String command : input){
           String[] commandInput = command.split(" ");
           switch (commandInput[0]) {
               case "DEPEND":
                   System.out.println(command);
                   executeDependent(commandInput);
                   break;
               case "INSTALL":
                   System.out.println(command);
                   excuteInstall(commandInput[1]);
                   break;
               case "REMOVE":
                   System.out.println(command);
                   excuteRemove(commandInput[1]);
                   break;
               case "LIST":
                   System.out.println(command);
                   excuteList();
                   break;
               case "END":
                   System.out.println(command);
           }

       }



    }


    public static void excuteList(){
        for(String s : install){
            System.out.println( s);
        }

    }

    public static void excuteRemove(String commandInput){
        if(!install.contains(commandInput)){
            System.out.println(commandInput +" is not installed " );
            return;
        }
        if(reverseDependencies.containsKey(commandInput)){
            LinkedList<String> components = reverseDependencies.get(commandInput);
            LinkedList<String> ls = (LinkedList<String>) components.clone();

            boolean fl = false;
            while(!ls.isEmpty()){
                String component =  ls.poll();
                if(!install.contains(component)){
                    fl = true;
                    System.out.println(commandInput +" is still needed ");
                    break;
                }

            }
            if(!fl){
                install.remove(commandInput);
                System.out.println("removing " +commandInput );
            }

        } else{
            install.remove(commandInput);
            System.out.println("removing " +commandInput );
            if(dependencies.containsKey(commandInput)){
                LinkedList<String> ls  = dependencies.get(commandInput);
                while(!ls.isEmpty()){
                    String component =  ls.poll();
                    install.remove(component)  ;
                    System.out.println("removing " +component );

                }

            }
        }

    }







    public static void executeDependent(String[] commandInput){
        LinkedList<String> ls = new LinkedList<String>();

        for(int i=2;i<commandInput.length;i++) {
            ls.add(commandInput[i]);
            if(!reverseDependencies.containsKey(commandInput[i])){
                reverseDependencies.put(commandInput[i],new LinkedList<String>());
            }
                reverseDependencies.get(commandInput[i]).add(commandInput[1]);


        }
        dependencies.put(commandInput[1],ls);
    }
    public static void excuteInstall(String commandInput){
        Stack<String> st = new Stack<String>();
       if(dependencies.containsKey(commandInput)){
          st.add(commandInput);
          visited.add(commandInput);
          LinkedList<String> components = dependencies.get(commandInput);
          LinkedList<String> ls = (LinkedList<String>) components.clone();
          while(!ls.isEmpty()){
             String component =  ls.poll();
              st.add(component);
              visited.add(commandInput);
             if(dependencies.containsKey(component)){
                 LinkedList<String> comp =  dependencies.get(component);
                 Iterator<String> it = comp.iterator();
                 while(it.hasNext()){
                    String component1 = it.next();
                     if(!visited.contains(component1))
                     ls.add(component1);
                 }

             }

          }
      } else{
          st.add(commandInput);
          visited.add(commandInput);
      }

      while(!st.isEmpty()) {
          String needToInstall = st.pop();
          if (!install.contains(needToInstall))
              System.out.println("installing " + needToInstall);
          install.add(needToInstall);
      }
      }


    }


