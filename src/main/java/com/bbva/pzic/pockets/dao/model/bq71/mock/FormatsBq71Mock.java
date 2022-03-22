package com.bbva.pzic.pockets.dao.model.bq71.mock;

import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ711;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public final class FormatsBq71Mock {

    private static final FormatsBq71Mock INSTANCE = new FormatsBq71Mock();

    private FormatsBq71Mock() {
    }

    public static FormatsBq71Mock getInstance() {
        return INSTANCE;
    }

    public FormatoBGMQ711 getFormatoBGMQ711() {
        FormatoBGMQ711 formatoBGMQ711 = new FormatoBGMQ711();
        formatoBGMQ711.setIdnmcta("123943469382943423");
        return formatoBGMQ711;
    }
}