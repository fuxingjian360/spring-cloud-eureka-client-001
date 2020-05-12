package designmodel.filter;

import java.util.ArrayList;
import java.util.List;

public interface IDataFilterChain {

    void doFilter(DataRequest dataRequest, DataResponse dataResponse);
}
