package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.InputCreatePocket;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38E1;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("txCreatePocketMapper")
public class TxCreatePocketMapper implements ITxCreatePocketMapper {
    /**
     * @see com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketMapper#mapIn(com.bbva.pzic.pockets.business.dto.InputCreatePocket)
     */
    @Override
    public FormatoBQM38E1 mapIn(InputCreatePocket dtoIn) {
        final FormatoBQM38E1 input = new FormatoBQM38E1();
        input.setNumcuen(dtoIn.getAccountPocketNumber());
        input.setTippock(dtoIn.getPocketTypeId());
        input.setNompoc(dtoIn.getName());
        input.setNomcor(dtoIn.getShortName());
        input.setMonpoc(dtoIn.getGoalAmountValue());
        input.setMoneda(dtoIn.getGoalAmountCurrency());
        input.setFechpoc(dtoIn.getGoalDate());
        input.setFlagpoc(converterBoolean(dtoIn.getIsAutomaticAmount()));
        if (dtoIn.getIsAutomaticAmount()) {
            input.setImpaut(dtoIn.getAutomaticAmountValue());
            input.setMonimp(dtoIn.getAutomaticAmountCurrency());
            input.setPeraut(dtoIn.getAutomaticAmountPeriodId());
            input.setDiaauto(dtoIn.getAutomaticAmountDayMonth());
        }
        return input;
    }

    /**
     * @see com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketMapper#mapOut(com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38S1)
     */
    @Override
    public PocketV00 mapOut(FormatoBQM38S1 formatOutput) {
        if (formatOutput == null) {
            return null;
        }
        PocketV00 pocket = new PocketV00();
        pocket.setId(formatOutput.getIdpoc());
        return pocket;
    }

    /**
     * Metodo que convierte un booleanos a String (true = S y false = N)
     *
     * @param isAutomaticAmount Parametro de tipo Booleano
     * @return {@link java.lang.String}
     */
    private String converterBoolean(Boolean isAutomaticAmount) {
        return isAutomaticAmount ? "S" : "N";
    }
}