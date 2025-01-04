package io.pn.report.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface WriteExcel {
    public byte[] writeExcel(String heading, List<String> headerList, Map<Integer,List<String>> databody, OutputStream outputStream) throws IOException;
}
