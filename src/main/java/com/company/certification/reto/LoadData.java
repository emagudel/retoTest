package com.company.certification.reto;


import java.util.List;
import java.util.Map;

import static com.company.certification.reto.ConstantManager.CLASE_TASK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoadData {

    private LoadData() {
        throw new IllegalStateException(CLASE_TASK);
    }

    public static LoadDataTest loadDataTestWithTheFollowing(List<Map<String, Object>> information) {
        return instrumented(LoadDataTest.class, information);
    }

}
