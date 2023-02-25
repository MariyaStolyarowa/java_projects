// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
import java.util.Map;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class HW2_1{

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
                Map<String, String> mymap = new HashMap<>();
                Object o = new JSONParser().parse(new FileReader("File.json"));
                JSONObject j = (JSONObject) o;
                mymap = j;
                
                String stringQuery = "select * from students where ";
                System.out.println(stringQuery + getQuery(mymap));
    }
    
    public static StringBuilder getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder("");
 
        for (Map.Entry<String, String> pair: params.entrySet()){
            try{
                if (!pair.getValue().equals("null")){
                    if(result.toString().length() > 1) {
                        result.append(" and ");
                    }
                    result.append(pair.getKey() + " = \'")
                            .append(pair.getValue() + "\'");
                }
            }catch (NullPointerException e){}
        }
        return result;    
}
}    

