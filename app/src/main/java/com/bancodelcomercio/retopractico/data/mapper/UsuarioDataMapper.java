package com.bancodelcomercio.retopractico.data.mapper;


import com.bancodelcomercio.retopractico.data.datasource.cloud.model.user.response.WsDataUser;
import com.bancodelcomercio.retopractico.domain.model.Address;
import com.bancodelcomercio.retopractico.domain.model.Company;
import com.bancodelcomercio.retopractico.domain.model.UserGeo;
import com.bancodelcomercio.retopractico.domain.model.Usuario;

import java.util.ArrayList;
import java.util.List;


public class UsuarioDataMapper {

    public UsuarioDataMapper() {
    }

    public List<Usuario> transformWsToLocal(List<WsDataUser> cloudUsers) {

        List<Usuario> localUsers = new ArrayList<>();
        for (WsDataUser wsDataUser : cloudUsers) {
            UserGeo userGeo = new UserGeo(wsDataUser.getAddress().getGeo().getLat(), wsDataUser.getAddress().getGeo().getLng());
            Address address = new Address(wsDataUser.getAddress().getStreet(), wsDataUser.getAddress().getSuite(), wsDataUser.getAddress().getCity(), wsDataUser.getAddress().getZipcode(), userGeo);
            Company company = new Company(wsDataUser.getCompany().getName(), wsDataUser.getCompany().getCatchPhrase(), wsDataUser.getCompany().getBs());
            Usuario localUser = new Usuario(wsDataUser.getId(), wsDataUser.getName(), wsDataUser.getUsername(), wsDataUser.getEmail(), address, wsDataUser.getPhone(), wsDataUser.getWebsite(), company);
            localUsers.add(localUser);
        }
        return localUsers;
    }


}
