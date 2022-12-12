package com.autotest.astarte.web.service;

import com.autotest.astarte.api.bean.AtpSystemBean;
import com.autotest.astarte.api.bean.common.AtpResponse;

public interface AtpSystemService {

    AtpResponse selectSystemList(AtpSystemBean entity);

    AtpResponse selectSystemOne(AtpSystemBean entity);

    AtpResponse saveSystem(AtpSystemBean entity);

    AtpResponse updateSystem(AtpSystemBean entity);

    AtpResponse deleteSystem(String ids);

}
