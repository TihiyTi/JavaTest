import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PseudoChart {
    private Map<String, Unit> map = new HashMap<>();
    
    private List<List<Unit>> list = new ArrayList<>();
    private Mapper mapper;

    public PseudoChart(Map<String, Unit> newMap){
        map = newMap;
        setting();
    }

    private void setting() {
        if(mapper==null){
            defaultSetting();
        }else {
            mapperSetting();
        }
    }
    private void defaultSetting() {
        list.clear();
        List<Unit> tempList = new ArrayList<>();
        map.keySet().forEach(e -> tempList.add(map.get(e)));
        list.add(tempList);
    }
    private void mapperSetting() {
        list.clear();
        for (int i = 0; i < mapper.max; i++) {
            list.add(new ArrayList<>());
        }
        mapper.map.keySet().forEach(e -> list.get(mapper.map.get(e) - 1).add(map.get(e)));
    }

    public void print(){
        list.forEach(e -> {
            System.out.print("[");
            e.forEach(ee -> {
                System.out.print(" " + ee.getValue() + " ");
            });
            System.out.print("]");
            System.out.println();
        });
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
        setting();
    }
}
