package com.bbva.pzic.pockets.util.orika.impl.generator;

import com.bbva.pzic.pockets.util.orika.metadata.Property;
import com.bbva.pzic.pockets.util.orika.metadata.Type;

public class MapEntryRef extends VariableRef {

	public enum EntryPart {
		KEY {{
		    this.prototype = new Property.Builder()
                .name("key")
                .expression("key")
                .getter("getKey()")
                .setter("setKey(%s)")
                .build();
	    	
		}},
		VALUE {{
			this.prototype = new Property.Builder()
			    .name("value")
			    .expression("value")
			    .getter("getValue()")
			    .setter("setValue(%s)")
			    .build();
		}};
		
		protected Property prototype;
		
		Property newProperty(Type<?> type) {
			return prototype.copy(type);
		}
	}
	
	public MapEntryRef(Type<?> type, String name, EntryPart entryPart) {
		super(entryPart.newProperty(type), name);
	}
	
	protected String getter() {
		return VariableRef.getGetter(property(), name);
	}
	
	protected String setter() {
		return VariableRef.getSetter(property(), name);
	}

}
