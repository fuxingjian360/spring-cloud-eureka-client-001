package designmodel.filter;

public interface IDataFilter {
    void doFilter(DataRequest dataRequest, DataResponse dataResponse, IDataFilterChain dataFilterChain);
}
