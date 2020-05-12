package designmodel.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Filter;

public class DataFilterChain implements IDataFilterChain {

    private final List<IDataFilter> filters;
    private final Iterator<IDataFilter> iterators;

    public DataFilterChain(List<IDataFilter> filters) {
        this.filters = filters;
        this.iterators = this.filters.iterator();
    }

    @Override
    public void doFilter(DataRequest dataRequest, DataResponse dataResponse) {
        if(iterators.hasNext()){
            IDataFilter filter = iterators.next();
            filter.doFilter(dataRequest,dataResponse,this);
        }
    }
}
