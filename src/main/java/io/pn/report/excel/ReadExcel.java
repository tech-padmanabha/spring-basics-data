package io.pn.report.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface ReadExcel {
    public Map<Integer, List<String>> readData(InputStream inStream) throws IOException;
}
