package designmodel.filter;

import java.util.ArrayList;
import java.util.List;

public class DataFilterTest {
    public static void main(String[] args) {
        IDataFilter iDataFilter001 = new DataFilter001();
        IDataFilter iDataFilter002 = new DataFilter002();
        IDataFilter iDataFilter003 = new DataFilter003();
        List<IDataFilter> list = new ArrayList<IDataFilter>();
        list.add(iDataFilter001);
        list.add(iDataFilter002);
        list.add(iDataFilter003);
        IDataFilterChain iDataFilterChain = new DataFilterChain(list);
        DataResponse response = new DataResponse();
        response.setData("开始");
        DataRequest request = new DataRequest();
        request.setHandleData("开始");
        iDataFilterChain.doFilter(request,response);
    }
}
