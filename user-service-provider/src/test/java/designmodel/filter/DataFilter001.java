package designmodel.filter;

import java.util.ArrayList;
import java.util.List;

public class DataFilter001 implements IDataFilter {


    @Override
    public void doFilter(DataRequest dataRequest, DataResponse dataResponse, IDataFilterChain dataFilterChain) {
        System.err.println("DataFilter001=>"+dataRequest.getHandleData());
        dataRequest.setHandleData("001");
        dataFilterChain.doFilter(dataRequest, dataResponse);
    }
}
