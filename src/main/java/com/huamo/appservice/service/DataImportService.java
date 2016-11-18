package com.huamo.appservice.service;

import java.util.Map;

/**
 * Created by luohh on 2016/10/24.
 */
public interface DataImportService {

    Integer insertCitySessionSummary(Map<String,Object> params);

    boolean checkIsAlreadyImport(Map<String,Object> params);
}
