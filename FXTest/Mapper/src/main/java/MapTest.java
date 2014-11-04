import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Unit> map = new HashMap<>();
        map.put("1", new Unit(1));
        map.put("2", new Unit(2));
        map.put("3", new Unit(3));
        map.put("4", new Unit(4));
        map.put("5", new Unit(5));
        map.put("6", new Unit(6));
        Mapper mapper = new Mapper();
        mapper.add("1", 1);
        mapper.add("2", 1);
        mapper.add("4", 3);
        mapper.add("5", 3);
        mapper.add("6", 3);
        PseudoChart chart =  new PseudoChart(map);
        chart.setMapper(mapper);
        chart.print();
    }
}
