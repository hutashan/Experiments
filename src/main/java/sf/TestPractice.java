package sf;

import java.util.*;


public class TestPractice {

    public static HashMap<String, Component> componentMap = new HashMap<String, Component>();
    public static LinkedHashSet<Component> installed = new LinkedHashSet<Component>();

    public class Component {
        // Name of component
        String componentName;

        boolean isInstalled;
        // Upstream
        public HashSet<Component> dependencies = new HashSet<Component>();
        // Upstream
        public HashSet<Component> dependent = new HashSet<Component>();

        public Component(String name) {
            componentName = name;
        }
    }


    public Component getComponent(String componentName) {
        Component component = componentMap.get(componentName);
        if (component == null) {
            component = new Component(componentName);
            componentMap.put(componentName, component);
        }
        return component;
    }


    public static void main(String[] args) {
        String[] input1 = {
                "DEPEND TELNET TCPIP NETCARD",
                "DEPEND TCPIP NETCARD",
                "DEPEND NETCARD TCPIP",
                "DEPEND DNS TCPIP NETCARD",
                "DEPEND BROWSER TCPIP HTML",
                "INSTALL NETCARD",
                "INSTALL TELNET",
                "INSTALL foo",
                "REMOVE NETCARD",
                "INSTALL BROWSER",
                "INSTALL DNS",
                "LIST",
                "REMOVE TELNET",
                "REMOVE NETCARD",
                "REMOVE DNS",
                "REMOVE NETCARD",
                "INSTALL NETCARD",
                "REMOVE TCPIP",
                "REMOVE BROWSER",
                "REMOVE TCPIP",
                "LIST",
                "END"
        };
        String[] input = {
                "DEPEND A B",
                "INSTALL B",
                "END"
        };


        new TestPractice().doIt(input);
    }


    void doIt(String[] input) {

        for (String commandLine : input) {
            String[] commandInput = commandLine.split(" ");

            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(commandInput));
            arrayList.remove(0);
            switch (commandInput[0]) {
                case "DEPEND":
                    System.out.println(commandLine);
                    executeDependent(arrayList);
                    break;
                case "INSTALL":
                    System.out.println(commandLine);
                    executeInstall(commandInput[1]);
                    break;
                case "REMOVE":
                    System.out.println(commandLine);
                    executeRemove(commandInput[1]);
                    break;
                case "LIST":
                    System.out.println(commandLine);
                    executeList();
                    break;
                case "END":
                    System.out.println(commandLine);
            }

        }


    }




    void run(String input) {


            String[] commandInput = input.split(" ");

            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(commandInput));
            arrayList.remove(0);
            switch (commandInput[0]) {
                case "DEPEND":
                    System.out.println(input);
                    executeDependent(arrayList);
                    break;
                case "INSTALL":
                    System.out.println(input);
                    executeInstall(commandInput[1]);
                    break;
                case "REMOVE":
                    System.out.println(input);
                    executeRemove(commandInput[1]);
                    break;
                case "LIST":
                    System.out.println(input);
                    executeList();
                    break;
                case "END":
                    System.out.println(input);
            }

        }









    //ToDO Can we do it recursion
    public  void executeRemove(String commandInput){
        Component component = getComponent(commandInput);
        if(component!=null && component.isInstalled){
            printResults(remove(component,true,0));
         } else{
            Map<String, String> output = new LinkedHashMap<String, String>();
            output.put(commandInput,"is not installed");
            printResults(output);
        }

    }

    // Todo Split/refactor this methods
    private Map<String, String> remove(Component component,boolean parent,int level) {
        Map<String, String> output = new LinkedHashMap<String, String>();
        if (level>1){
            return output;
        }
        Set<Component> installedDependents = new HashSet<>();

        for(Component dependent : component.dependent){
            if(dependent.isInstalled){
                installedDependents.add(dependent);
            }
        }

        if(installedDependents.isEmpty()) {
            if(component.isInstalled) {
                output.put("Removing "+component.componentName, "");
                component.isInstalled = false;
                installed.remove(component);
            }  else{
                output.put(component.componentName, "is not installed");
            }
            ArrayList<Component> newRemoveDependecies = new ArrayList<>();
            for(Component com : installed){
                if(component.dependencies.contains(com)){
                    newRemoveDependecies.add(com);
                }
            }


            for (Component depenency : newRemoveDependecies) {
                if (depenency.isInstalled) {
                    output.putAll(remove(depenency,false,level+1));
                }
            }
        } else{
            if(level==0)
            output.put(component.componentName,"is still needed");
        }
        return output;
    }






    public void executeList(){
        Map<String, String> output = new LinkedHashMap<String, String>();
      /* for(Component component: componentMap.values()){
           if(component.isInstalled){
               output.put(component.componentName,"");
           }
       } */
        for(Component component: installed){
            output.put(component.componentName,"");
        }
        printResults(output);
    }




    public  void executeDependent(ArrayList<String> commandInput) {
        Component component = getComponent(commandInput.get(0));
        for (int i = 1; i < commandInput.size(); i++) {
            Component dependentComponent = getComponent(commandInput.get(i));
            if(!component.dependent.contains(dependentComponent)) {
                component.dependencies.add(dependentComponent);
                dependentComponent.dependent.add(component);
            }else{
                System.out.println(dependentComponent.componentName+ " depends on " +component.componentName +", ignoring command");
            }
        }
    }


    public void executeInstall(String componentName){
        Map<String, String> output =
                install(getComponent(componentName),new LinkedHashMap<String, String>());
        printResults(output);
    }



    public Map<String, String> install(Component component,Map<String, String> output){
        if(!component.isInstalled){
            component.isInstalled=true;
            for(Component dependency : component.dependencies){
                if (!dependency.isInstalled) { // not entirely necessary
                    install(dependency,output);
                }
              //  output.put(component.componentName, "successfully installed");
            }
            output.put("Installing "+component.componentName, "");
            installed.add(component);
        } else{
            output.put(component.componentName,  "is already installed");
        }
        return output;

    }

    public void printResults (Map<String, String> output){
        for(Map.Entry<String,String> outputPrint : output.entrySet()){
            System.out.println(outputPrint.getKey() +" "+ outputPrint.getValue());
        }
    }




}
