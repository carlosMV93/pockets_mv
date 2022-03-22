package com.bbva.pzic.pockets.util;

import com.bbva.jee.arq.spring.core.connector.crypto.CryptoConfig;
import com.bbva.jee.arq.spring.core.connector.crypto.CryptoConnector;
import com.bbva.jee.arq.spring.core.connector.crypto.CryptoInput;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.routine.utils.ActiveCryptoChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldCryptoOperations {

    private CryptoConnector cryptoConnector;
    private ActiveCryptoChecker activeCryptoChecker;

    @Autowired
    public FieldCryptoOperations(CryptoConnector cryptoConnector, ActiveCryptoChecker activeCryptoChecker) {
        this.cryptoConnector = cryptoConnector;
        this.activeCryptoChecker = activeCryptoChecker;
    }

    public void encryptInputCreatePocketLiquidate(InputCreatePocketLiquidate input) {
        activeCryptoChecker
                .forField(
                        "SMCPE1810348",
                        "pockeid",
                        (cryptoKey) -> {
                            CryptoConfig cryptoConfig = new CryptoConfig(cryptoKey);
                            if (input.getPocketId() != null) {
                                input.setPocketId(cryptoConnector.execute(
                                                new CryptoInput.Builder().data(input.getPocketId(), "B64URL").build(),
                                                cryptoConfig)
                                        .getFirstData()
                                        .orElse(input.getPocketId()));
                            }
                        });
    }
}