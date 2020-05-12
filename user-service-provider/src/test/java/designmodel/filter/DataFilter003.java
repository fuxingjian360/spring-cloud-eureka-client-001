package designmodel.filter;

public class DataFilter003 implements IDataFilter {
    @Override
    public void doFilter(DataRequest dataRequest, DataResponse dataResponse, IDataFilterChain dataFilterChain) {
        System.err.println("DataFilter003=>"+dataRequest.getHandleData());
        dataRequest.setHandleData("003");
        dataFilterChain.doFilter(dataRequest, dataResponse);
    }
}
