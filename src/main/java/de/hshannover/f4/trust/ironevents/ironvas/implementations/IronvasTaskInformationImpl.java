/*
 * #%L
 * =====================================================
 *   _____                _     ____  _   _       _   _
 *  |_   _|_ __ _   _ ___| |_  / __ \| | | | ___ | | | |
 *    | | | '__| | | / __| __|/ / _` | |_| |/ __|| |_| |
 *    | | | |  | |_| \__ \ |_| | (_| |  _  |\__ \|  _  |
 *    |_| |_|   \__,_|___/\__|\ \__,_|_| |_||___/|_| |_|
 *                             \____/
 * 
 * =====================================================
 * 
 * Hochschule Hannover
 * (University of Applied Sciences and Arts, Hannover)
 * Faculty IV, Dept. of Computer Science
 * Ricklinger Stadtweg 118, 30459 Hannover, Germany
 * 
 * Email: trust@f4-i.fh-hannover.de
 * Website: http://trust.f4.hs-hannover.de
 * 
 * This file is part of ironevents, version 0.0.1, implemented by the Trust@HsH
 * research group at the Hochschule Hannover.
 * %%
 * Copyright (C) 2011 - 2018 Trust@HsH
 * %%
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
 * #L%
 */
package de.hshannover.f4.trust.ironevents.ironvas.implementations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.hshannover.f4.trust.ironevents.ironvas.interfaces.IronvasTaskInformation;

public class IronvasTaskInformationImpl implements IronvasTaskInformation{
	
	@JsonProperty("ip")
	private final String mIP; // IP of the device that should be scanned

	@JsonProperty("namePrefix")
	private final String mNamePrefix; // name prefix for the target name

	@JsonProperty("timestamp")
	private final long mTimestamp; // The timestamp of the event creation to identify a task.

	@JsonCreator
	public IronvasTaskInformationImpl(@JsonProperty("mIP") String ip, @JsonProperty("mNamePrefix") String namePrefix, @JsonProperty("mTimestamp") long timestamp) {
		/*if (!InetAddressValidator.getInstance().isValidInet4Address(ip)) {
			throw new IllegalArgumentException("The given string is not a valid IPV4 address.");
		}*/
		this.mIP = ip;
		this.mNamePrefix = namePrefix;
		this.mTimestamp = timestamp;
	}

	@Override
	public String getIP() {
		return this.mIP;
	}

	@Override
	public String getNamePrefix() {
		return this.mNamePrefix;
	}

	@Override
	public long getTimestamp() {
		return this.mTimestamp;
	}
}
