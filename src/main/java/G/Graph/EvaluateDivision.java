package G.Graph;

import java.util.HashMap;
import java.util.HashSet;

public class EvaluateDivision {
    public static void main(String arg[]){
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        System.out.println(new EvaluateDivision().calcEquation(equations,values,queries));
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        HashMap<String,HashMap<String, Double>> map = new HashMap<>();
        for (int i=0;i<equations.length;i++) {
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new HashMap<String, Double>());
            }
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new HashMap<String, Double>());
            }
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1.0 / values[i]);
        }
        double[] result = new double[queries.length];
        for(int i=0;i<queries.length;i++){
            result[i]=cal(map,queries[i][0],queries[i][1],new HashSet<String>());

        }
        return result;
    }
    public double cal(HashMap<String,HashMap<String, Double>> map, String x, String y, HashSet<String> visited){
        if((!map.containsKey(x) || !map.containsKey(y)||visited.contains(x))){
            return -1.0;
        }
        visited.add(x);
        if (map.get(x).containsKey(y)) {
            return map.get(x).get(y);
        }
        for(String k : map.get(x).keySet()){
            double ans = cal(map, k, y, visited);
            if (ans != -1.0) {
                return map.get(x).get(k) * ans;
            }
        }
        return -1.0;
    }
}
