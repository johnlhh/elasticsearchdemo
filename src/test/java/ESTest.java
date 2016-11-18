import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohh on 2016/10/14.
 */
public class ESTest {
    /**
     * 创建索引并批处理添加文档
     * @throws UnknownHostException
     * @throws JsonProcessingException
     */
    /*@Test
    public void testCreatIndex() throws UnknownHostException, JsonProcessingException {
        List<Goods> goodsList = new ArrayList<>();

        String[] r123 = {"r1","r2","r3"};
        String[] r23 = {"r2","r3"};
        goodsList.add(new Goods(1L, "雀巢咖啡", r123));
        goodsList.add(new Goods(2L, "雀巢咖啡", r23));

        goodsList.add(new Goods(3L, "星巴克咖啡", r123));
        goodsList.add(new Goods(4L, "可口可乐", r123));

        ESUtils.createIndex(goodsList);
    }*/

    /**
     * 查询索引文档
     * @throws IOException
     */
   /* @Test
    public void testSearchIndex() throws IOException {

        GoodsFilter2ES goodsFilter2ES = new GoodsFilter2ES();
        goodsFilter2ES.setQueryStr("星巴克");
        goodsFilter2ES.setRegionId("r2");
        List<Goods> goodses = ESUtils.search(goodsFilter2ES);
        for(Goods goods : goodses){
            System.out.println(goods);
        }
    }*/

    /**
     * 添加文档
     * @throws JsonProcessingException
     * @throws UnknownHostException
     */
    /*@Test
    public void testAddDocument() throws JsonProcessingException, UnknownHostException {
        ESUtils.addDocument("test_index","goods",new Goods(7L, "农夫山泉",new String[]{"r1","r2","r3"}));
    }*/

   /* @Test
    public void testdeleteDocument() throws UnknownHostException {
        ESUtils.deleteDocument("test_index","goods",7l);
    }*/



}
