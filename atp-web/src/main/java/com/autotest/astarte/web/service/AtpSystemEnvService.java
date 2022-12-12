package com.autotest.astarte.web.service;

import com.autotest.astarte.api.bean.AtpSystemBean;
import com.autotest.astarte.api.bean.AtpSystemEnvBean;
import com.autotest.astarte.api.bean.common.AtpResponse;

public interface AtpSystemEnvService {

    AtpResponse selectSystemEnvList(AtpSystemEnvBean entity);

    AtpResponse selectSystemEnvOne(AtpSystemEnvBean entity);

    AtpResponse saveSystemEnv(AtpSystemEnvBean entity);

    AtpResponse updateSystemEnv(AtpSystemEnvBean entity);

    AtpResponse deleteSystemEnv(String ids);

}
