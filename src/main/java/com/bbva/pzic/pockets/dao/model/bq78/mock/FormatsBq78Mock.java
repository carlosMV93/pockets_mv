package com.bbva.pzic.pockets.dao.model.bq78.mock;

import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78S1;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;
import java.io.IOException;

/**
 * Created on 16/10/2018.
 * 
 * @author Entelgy
 */
public final class FormatsBq78Mock {

	private static final FormatsBq78Mock INSTANCE = new FormatsBq78Mock();
	private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

	private FormatsBq78Mock() {
	}

	public static FormatsBq78Mock getInstance() {
		return INSTANCE;
	}

	public FormatoBQM78S1 getFormatoBQM78S1() throws IOException {
		return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq78/mock/formatoBQM78S1.json"), FormatoBQM78S1.class);
	}

	public FormatoBQM78S1 getFormatoBQM78S1Empty() throws IOException {
		return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq78/mock/formatoBQM78S1-EMPTY.json"), FormatoBQM78S1.class);
	}

}