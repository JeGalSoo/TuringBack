package com.turing.api.common;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractRepository {

    public abstract Map<String,?> saveBugs (Map<String,?> paramMap) throws IOException;


    public abstract Map<String,?> saveMelon(Map<String, String> paramMap) throws IOException;

}
