package com.example.desrrollo.config;

import com.example.desrrollo.util.ConstantesBD;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class ClienteConfig extends AbstractRoutingDataSource {
    @Autowired
    DataSourceMap dataSources;

    @Override
    protected Object determineCurrentLookupKey() {
        setDataSources(dataSources);
        afterPropertiesSet();

        if (SecurityContextHolder.getContext().getAuthentication() != null) {

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            return request.getSession().getAttribute("Key");

        } else {
            return ConstantesBD.session;
        }
    }

    @Autowired
    public void setDataSources(DataSourceMap dataSources) {
        setTargetDataSources(dataSources.getDataSourceMap());
    }

}







