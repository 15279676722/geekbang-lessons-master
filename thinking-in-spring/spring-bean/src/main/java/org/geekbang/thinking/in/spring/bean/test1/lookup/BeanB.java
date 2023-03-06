package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BeanB {


    private LookUpBean lookUpBean;

    public LookUpBean getLookUpBean() {
        return lookUpBean;
    }
    @Autowired
    public void setLookUpBean(LookUpBean lookUpBean) {
        this.lookUpBean = lookUpBean;
    }
}
