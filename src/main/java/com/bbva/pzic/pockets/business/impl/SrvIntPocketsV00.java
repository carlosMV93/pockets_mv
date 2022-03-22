package com.bbva.pzic.pockets.business.impl;

import com.bbva.pzic.pockets.business.ISrvIntPocketsV00;
import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.IPocketsDAOV00;
import com.bbva.pzic.routine.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Component("srvIntPocketsV00")
public class SrvIntPocketsV00 implements ISrvIntPocketsV00 {

    @Autowired
    private Validator validator;

    @Autowired
    private IPocketsDAOV00 dao;

    @Override
    public PocketV00 createPocket(InputCreatePocket input) {
        validator.validate(input, ValidationGroup.CreatePocket.class);
        return dao.createPocket(input);
    }

    @Override
    public void modifyPocket(final DTOIntPocket dtoIntPocket) {
        validator.validate(dtoIntPocket, ValidationGroup.ModifyPocket.class);
        dao.modifyPocket(dtoIntPocket);
    }

    @Override
    public void deletePocket(final DTOIntPocket dtoIntPocket) {
        validator.validate(dtoIntPocket, ValidationGroup.DeletePocket.class);
        dao.deletePocket(dtoIntPocket);
    }

    @Override
    public DTOIntPocketsData listPockets(InputListPocket inputListPocket) {
        validator.validate(inputListPocket, ValidationGroup.ListPocketsV00.class);
        return dao.listPockets(inputListPocket);
    }

    @Override
    public PocketData getPocket(PathParamPocketId input) {
        validator.validate(input, ValidationGroup.GetPocket.class);
        return dao.getPocket(input);
    }

    @Override
    public DTOIntTransaction createPocketTransaction(DTOIntTransaction transaction) {
        validator.validate(transaction, ValidationGroup.CreatePocketTransaction.class);
        return dao.createPocketTransaction(transaction);
    }

    @Override
    public DTOOutPocketTransactions listPocketTransactions(InputListPocketTransactions input) {
        validator.validate(input, ValidationGroup.ListPocketTransactions.class);
        return dao.listPocketTransactions(input);
    }
}