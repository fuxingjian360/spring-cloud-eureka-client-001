package designmodel.filter;

public class DataFilter002 implements IDataFilter {
    @Override
    public void doFilter(DataRequest dataRequest, DataResponse dataResponse, IDataFilterChain dataFilterChain) {
        System.err.println("DataFilter002=>"+dataRequest.getHandleData());
        dataRequest.setHandleData("002");
        dataFilterChain.doFilter(dataRequest, dataResponse);
    }
}
