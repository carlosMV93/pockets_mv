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

package com.bbva.pzic.pockets.util.orika.impl;

import com.bbva.pzic.pockets.util.orika.OrikaSystemProperties;
import com.bbva.pzic.pockets.util.orika.constructor.ConstructorResolverStrategy;
import com.bbva.pzic.pockets.util.orika.constructor.SimpleConstructorResolverStrategy;
import com.bbva.pzic.pockets.util.orika.converter.ConverterFactory;
import com.bbva.pzic.pockets.util.orika.converter.DefaultConverterFactory;
import com.bbva.pzic.pockets.util.orika.impl.generator.CompilerStrategy;
import com.bbva.pzic.pockets.util.orika.impl.generator.JavassistCompilerStrategy;
import com.bbva.pzic.pockets.util.orika.metadata.ClassMapBuilderFactory;
import com.bbva.pzic.pockets.util.orika.property.ListPropertyResolverStrategy;
import com.bbva.pzic.pockets.util.orika.property.PropertyResolverStrategy;

/**
 * UtilityResolver is used to resolve implementations for the various
 * customizable utility types used in Orika.
 * 
 * @author matt.deboer@gmail.com
 * 
 */
public abstract class UtilityResolver {
    
    /**
     * Provides a default compiler strategy, favoring a type specified in the
     * appropriate system property if found.
     * 
     * @return
     */
    public static CompilerStrategy getDefaultCompilerStrategy() {
        return resolveUtility(OrikaSystemProperties.COMPILER_STRATEGY, JavassistCompilerStrategy.class);
    }
    
    /**
     * Provides a default constructor resolver strategy, favoring a type
     * specified in the appropriate system property if found.
     * 
     * @return
     */
    public static ConverterFactory getDefaultConverterFactory() {
        return resolveUtility(OrikaSystemProperties.CONVERTER_FACTORY, DefaultConverterFactory.class);
    }
    
    /**
     * Provides a default constructor resolver strategy, favoring a type
     * specified in the appropriate system property if found.
     * 
     * @return
     */
    public static ConstructorResolverStrategy getDefaultConstructorResolverStrategy() {
        return resolveUtility(OrikaSystemProperties.CONSTRUCTOR_RESOLVER_STRATEGY, SimpleConstructorResolverStrategy.class);
    }
    
    /**
     * Provides a default constructor resolver strategy, favoring a type
     * specified in the appropriate system property if found.
     * 
     * @return
     */
    public static PropertyResolverStrategy getDefaultPropertyResolverStrategy() {
        return resolveUtility(OrikaSystemProperties.PROPERTY_RESOLVER_STRATEGY, ListPropertyResolverStrategy.class);
        
    }
    
    /**
     * Provides a default ClassMapBuilderFactory instance, favoring a type
     * specified in the appropriate system property if found.
     * 
     * @return
     */
    public static ClassMapBuilderFactory getDefaultClassMapBuilderFactory() {
        return resolveUtility(OrikaSystemProperties.CLASSMAP_BUILDER_FACTORY, com.bbva.pzic.pockets.util.orika.metadata.ClassMapBuilder.Factory.class);
    }
    
    /**
     * Resolves a utility implementation, given a system property for customized
     * instance, and a default implementation class.
     * 
     * @param systemProperty
     * @param defaultImplementation
     * @return
     */
    private static <U> U resolveUtility(String systemProperty, Class<? extends U> defaultImplementation) {
        
        U utility = null;
        String utilityClassName = System.getProperty(systemProperty);
        if (utilityClassName != null) {
            
            try {
                @SuppressWarnings("unchecked")
                Class<? extends U> utilityClass = (Class<? extends U>) Class.forName(utilityClassName, true, Thread.currentThread()
                        .getContextClassLoader());
                utility = utilityClass.newInstance();
                
            } catch (Exception e) {
                throw new IllegalArgumentException("utility implementation specified for " + systemProperty + " was invalid", e);
            }
            
        } else {
            try {
                utility = defaultImplementation.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return utility;
    }
    
}
