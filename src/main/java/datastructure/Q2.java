package datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Implement TRIES datastucter


 */




public class Q2 {

    static class TrieNode {
        String path;
        String endPoint;
        HashMap<String,TrieNode> children = new HashMap<String,TrieNode>();
        public TrieNode(String path, String endpoint) {
            this.path = path;
            this.endPoint = endpoint;
        }
    }
    private static TrieNode root;
    public static void insert(List<Route> routes) {
        for(int i=0; i<routes.size(); i++){
            HashMap<String, TrieNode> children = root.children;
            Route r= routes.get(i);
            String rPath = r.path;
            String rendpoint = r.endpoint;
            TrieNode t;
            String[] pths = rPath.split("\\/");
            if (pths.length ==0){
                String newPath = rPath;
                root = new TrieNode("/",rendpoint);
                children = root.children;
            } else {
                for (int j=0;j<pths.length;j++) {
                    String newPath = pths[j];
                    if (!newPath.equals("")) {
                        if (children.containsKey(newPath)) {
                            t = children.get(newPath);
                        } else {
                            t = new TrieNode(newPath, rendpoint);
                            children.put(newPath, t);
                        }
                        children = t.children;
                    }
                }
            }
        }
    }


    public static List<String> findEndpoints(List<String> paths) {
        List<String> endPoints = new ArrayList<String>();
        String endPointResult ="";
        for (int i = 0; i < paths.size(); i++) {
            Map<String, TrieNode> children = root.children;
            String path = paths.get(i);
            TrieNode t = null;
            String[] pths = path.split("\\/");
            if (pths.length == 0) {
                endPointResult = root.endPoint;
            } else {
                for (int j = 0; j < pths.length; j++) {
                    String newPath = pths[j];
                    if (!newPath.equals("")) {
                        if (children.containsKey(newPath) || children.containsKey("X")) {
                            if (children.containsKey(newPath))
                               // This logic will check for wildcards , check child of child based on decide path
                                if ((j+1 < pths.length && children.get(newPath).children.containsKey(pths[j+1]) || children.get(newPath).children.containsKey("X") ) ||(j+1 == pths.length) ) {
                                   t = children.get(newPath);
                               } else { // this is just for pre wildcards and here checking child of child
                                   if (children.get("X") != null && children.get("X").children!=null) {
                                       if (j + 1 < pths.length && children.get("X").children.containsKey(pths[j + 1])) {
                                           t = children.get("X");
                                       }
                                   } else {
                                       endPointResult = "404";
                                   }
                               }
                            else {
                                t = children.get("X");
                            }
                            if (j == pths.length - 1) {
                                endPointResult= t.endPoint;
                            }
                            children = t.children;
                        } else {
                            endPointResult = "404";
                        }
                    }
                }
            }
            endPoints.add(endPointResult);
        }
        return endPoints;
    }


    private static List<String> routeAll(List<Route> routes, List<String> paths) {
        List<String> endpoints = new ArrayList<String>();
        // Your code here
        // Tries is good way to implement
        root = new TrieNode("/","");
        insert(routes);
        endpoints = findEndpoints(paths);
        return endpoints;
    }








    /**
     *      Hey! You probably won't need to edit anything below here.
     */

    static class Route {
        String path;
        String endpoint;
        public Route(String path, String endpoint) {
            this.path = path;
            this.endpoint = endpoint;
        }
    }

    private static List<Route> getRoutes(InputStream is) throws IOException {
        List<Route> routes = new ArrayList<Route>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            String[] tokenizedLine = line.split(" ");
            routes.add(new Route(tokenizedLine[0], tokenizedLine[1]));
        }
        return routes;
    }
   //hard coded because it is not working for me
    private static List<String> getPaths(InputStream is) throws IOException {
        File file = new File("src/data/input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> paths = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            paths.add(line);
        }
        return paths;
    }

    public static void main(String... args) throws IOException {
        List<Route> routes = Q2.getRoutes(new FileInputStream(args[0]));
        List<String> paths = Q2.getPaths(System.in);

        for(String endpoint : Q2.routeAll(routes, paths)) {
            System.out.println(endpoint);
        }
    }
}
