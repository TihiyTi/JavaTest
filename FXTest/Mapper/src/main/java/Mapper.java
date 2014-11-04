import java.util.HashMap;
import java.util.Map;

public class Mapper {
    Map<String, Integer> map = new HashMap<>();
    int max = 0;

    public void add(String name, int number){
        if(max < number){
            max = number;
        }
        map.put(name, number);
    }
}
