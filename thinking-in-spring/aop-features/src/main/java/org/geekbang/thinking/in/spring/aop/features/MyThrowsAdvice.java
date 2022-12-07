/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geekbang.thinking.in.spring.aop.features;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 可以定义多种 exception的捕获方法
 * 方法名要 afterThrowing开头 参数为1个或者4个
 * 最后一个参数要是Throwable类型的
 * 如果定义相同得Throwable类型会被覆盖
 * @since
 */
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(RuntimeException e) {
        System.out.printf("Exception : %s\n", e);
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.printf("Method : %s , args : %s , target : %s, exception : %s\n",
                method,
                Arrays.asList(args),
                target,
                e
        );
    }
}
