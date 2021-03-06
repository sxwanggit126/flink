/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.dist;

import org.apache.flink.configuration.ConfigurationUtils;
import org.apache.flink.runtime.util.BashJavaUtils;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Tests for BashJavaUtils.
 *
 * <p>This test requires the distribution to be assembled and is hence marked as an IT case which run after packaging.
 */
public class BashJavaUtilsITCase extends JavaBashTestBase {

	private static final String RUN_BASH_JAVA_UTILS_CMD_SCRIPT = "src/test/bin/runBashJavaUtilsCmd.sh";

	@Test
	public void testGetTmResourceDynamicConfigs() throws Exception {
		String[] command = {RUN_BASH_JAVA_UTILS_CMD_SCRIPT,
			BashJavaUtils.Command.GET_TM_RESOURCE_DYNAMIC_CONFIGS.toString()};
		String result = executeScript(command);

		assertNotNull(result);
		ConfigurationUtils.parseTmResourceDynamicConfigs(result);
	}

	@Test
	public void testGetTmResourceJvmParams() throws Exception {
		String[] command = {RUN_BASH_JAVA_UTILS_CMD_SCRIPT,
			BashJavaUtils.Command.GET_TM_RESOURCE_JVM_PARAMS.toString()};
		String result = executeScript(command);

		assertNotNull(result);
		ConfigurationUtils.parseTmResourceJvmParams(result);
	}
}
