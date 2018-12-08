package four;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Q2 {
    /**
     * Using Ties to solve this problem.
     */
    static class TrieNode {
        String path;
        String endPoint;
        HashMap<String,TrieNode> children = new HashMap<String,TrieNode>();
        public TrieNode(String path, String endpoint) {
            this.path = path;
            this.endPoint = endpoint;
        }
    }
    /**
     * Inner class of routes
     */
    static class Route {
        String path;
        String endpoint;
        public Route(String path, String endpoint) {
            this.path = path;
            this.endpoint = endpoint;
        }
    }
    private static TrieNode root=null;
   /**
     * insert into Tries.
     * @param routes
     */
    public static void insert(List<Route> routes) {
        for(int i=0; i<routes.size(); i++){
            HashMap<String, TrieNode> children = root.children;
            Route r= routes.get(i);
            String rPath = r.path;
            String rendpoint = r.endpoint;
            TrieNode t;
            String[] pths = rPath.split("\\/");
            if (pths.length ==1 ){   // to handle changed root path . If not then we can ignore.
                       root.endPoint=rendpoint;
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

    /**
     * Find end point based on input paths.
     * @param paths
     * @return
     */
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
        // Setting up root of tries.
        root = new TrieNode("/","rootendpoint");
        insert(routes);
        endpoints = findEndpoints(paths);
        return endpoints;
    }




    /**
     * get Routes from STDIN
     * @param reader
     * @return list[Routes]
     * @throws IOException
     */
    private static List<Route> getRoutes(BufferedReader reader) throws IOException {
        List<Route> routes = new ArrayList<Route>();
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            if(line.startsWith("#"))  return routes;
                String[] tokenizedLine = line.split(" ");
                routes.add(new Route(tokenizedLine[0], tokenizedLine[1]));

        }
        return routes;
    }

    /**
     * get paths for all STDIN
     * @param reader
     * @return List[Paths]
     * @throws IOException
     */
    private static List<String> getPaths(BufferedReader reader) throws IOException {
        List<String> paths = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            paths.add(line);
        }
        return paths;
    }

    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Route> routes = Q2.getRoutes(reader);
        List<String> paths = Q2.getPaths(reader);
        for(String endpoint : Q2.routeAll(routes, paths)) {
            System.out.println(endpoint);
        }
    }
}
