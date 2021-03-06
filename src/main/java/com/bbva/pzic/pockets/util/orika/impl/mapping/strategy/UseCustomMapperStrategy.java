/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bbva.pzic.pockets.util.orika.impl.mapping.strategy;

import com.bbva.pzic.pockets.util.orika.Mapper;
import com.bbva.pzic.pockets.util.orika.MappingContext;
import com.bbva.pzic.pockets.util.orika.metadata.Type;
import com.bbva.pzic.pockets.util.orika.unenhance.UnenhanceStrategy;

public abstract class UseCustomMapperStrategy implements MappingStrategy {
    
    protected final DirectionalCustomMapperReference customMapper;
    protected final Type<Object> sourceType;
    protected final Type<Object> destinationType;
    protected final UnenhanceStrategy unenhancer;
    
    public UseCustomMapperStrategy(Type<Object> sourceType, Type<Object> destinationType, DirectionalCustomMapperReference customMapper, UnenhanceStrategy unenhancer) {
        this.sourceType = sourceType;
        this.destinationType = destinationType;
        this.customMapper = customMapper;
        this.unenhancer = unenhancer;
    }

    public Object map(final Object sourceObject, final Object destinationObject, final MappingContext context) {
        
        context.beginMapping();
        
    	Object resolvedSourceObject = unenhancer.unenhanceObject(sourceObject, sourceType);
        
        Object newInstance = getInstance(resolvedSourceObject, destinationObject, context);
        
        context.cacheMappedObject(sourceObject, destinationType, newInstance);
        
        customMapper.map(resolvedSourceObject, newInstance, context);
        
        context.endMapping();
        
        return newInstance;
    }
    
    protected abstract Object getInstance(Object sourceObject, Object destinationObject, MappingContext context);
    
    public static interface DirectionalCustomMapperReference {
    	public void map(Object sourceObject,
    			Object destinationObject, MappingContext context); 
    }
    
    public static class ForwardMapperReference implements DirectionalCustomMapperReference {

    	protected Mapper<Object, Object> customMapper;
    	
    	public ForwardMapperReference(Mapper<Object, Object> customMapper) {
    		this.customMapper = customMapper;
    	}
    	
		public void map(Object sourceObject,
				Object destinationObject, MappingContext context) {
			customMapper.mapAtoB(sourceObject, destinationObject, context);
		}
		
		public String toString() {
		    return customMapper.getClass().getSimpleName() + ".mapAtoB";
		}
    }
    
    public static class ReverseMapperReference extends ForwardMapperReference {

    	public ReverseMapperReference(Mapper<Object, Object> customMapper) {
    		super(customMapper);
    	}
    	
    	@Override
		public void map(Object sourceObject,
				Object destinationObject, MappingContext context) {
			customMapper.mapBtoA(sourceObject, destinationObject, context);
		}
    	
    	public String toString() {
            return customMapper.getClass().getSimpleName() + ".mapBtoA";
        }
    }
}
