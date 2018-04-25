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
import de.hshannover.f4.trust.ironevents.implementations.EventImpl;
import de.hshannover.f4.trust.ironevents.ironvas.common.RiskfactorLevel;
import de.hshannover.f4.trust.ironevents.ironvas.common.ThreatLevel;
import de.hshannover.f4.trust.ironevents.ironvas.interfaces.IronvasEvent;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * This class contains informations related to a vulnerability detected by OpenVAS emitted by ironvas_EventsToAMQP
 *
 * @author Marius Rohde, Hochschule Hannover
 *
 */

public class IronvasEventImpl extends EventImpl implements IronvasEvent {

	/**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    
    private final String mNvtOid; //'OpenVAS Network Vulnerability Tests ID': unique ID of the test, that ran on the host to find the vulnerability
    
    private final Float mCvssBase; //Basic score for the vulnerability given by the'"Common Vulnerability Scoring System'
    
    private final ThreatLevel mThreat; // Thread level = (High|Medium|Low|Log|Debug)
    
    private final RiskfactorLevel mRiskFactor; // Risk factor = (None|Low|Medium|High|Critical). See http://www.openvas.org/openvas-cr-42.html
   
    private final String mResultId; //  Unique ID per scan
    
    private final String mIfMapPublisherID; //to be able to determine which IF-MAP publisher sent this event
    
    private final Boolean mNewEventFlag; //is true, when ironvas detects the event the first time
    
    private final String mSubnet; // the subnet representation
    
    private final String mHost; // the host representation
    
    private final String mPort; // the port representation
    
    private final String mDescription; // the description...
    
    private final String mName; // the name...
    
    private final String mCve; // the cve number
    
    private final String mBid; // the bid number
    
    @JsonCreator
    public IronvasEventImpl(
    		@JsonProperty("ri") String resultId, 
    		@JsonProperty("ti") long timestamp, 
    		@JsonProperty("sn") String subnet, 
    		@JsonProperty("ho") String host,
    		@JsonProperty("po") String port, 
            @JsonProperty("tl") ThreatLevel threat,
            @JsonProperty("de") String description, 
            @JsonProperty("oi") String nvtOid, 
            @JsonProperty("na") String name, 
            @JsonProperty("cb") float cvssBase,
            @JsonProperty("rf") RiskfactorLevel riskFactor, 
            @JsonProperty("cv") String cve, 
            @JsonProperty("bi") String bid, 
            @JsonProperty("ip") String ifMapPublisherID, 
            @JsonProperty("ef") boolean newEvent) 
    {
    	super(new Timestamp(System.currentTimeMillis()), new Timestamp(timestamp));

    	this.mResultId = resultId; //set result id (unique per scan)
        this.mRiskFactor = riskFactor; //set risk factor 
        this.mThreat = threat; //set thread level
        this.mNvtOid = nvtOid; //unique ID of the testRoutine that has been run on the host to find the vulnerability
        this.mCvssBase = cvssBase; //set basic score of vulnerability, given by 'Common Vulnerability Scoring System'
        this.mIfMapPublisherID = ifMapPublisherID; // set puplisher ID of sensor, that published the event
        this.mNewEventFlag = newEvent; //set newEventFlag to know if this event occured the first time

        this.mSubnet = subnet;
        this.mHost = host;
        this.mPort = port;
        this.mDescription = description;
        this.mName = name;
        this.mCve = cve;
        this.mBid = bid;
    }

  
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getUuid()
	 */
    @Override
    public UUID getUuid() {
        return this.uuid;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getBid()
	 */
    @Override
    public String getBid() {
        return this.mBid;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getCvssbase()
	 */
    @Override
	public float getCvssbase() {
        return this.mCvssBase;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getDescription()
	 */
    @Override
    public String getDescription() {
        return this.mDescription;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getHost()
	 */
    @Override
    public String getHost() {
        return this.mHost;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getPublisherId()
	 */
    @Override
    public String getPublisherId() {
        return this.mIfMapPublisherID;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getName()
	 */
    @Override
    public String getName() {
        return this.mName;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getNewEventFlag()
	 */
    @Override
    public Boolean getNewEventFlag() {
        return this.mNewEventFlag;
    }
  
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getNvtOid()
	 */
    @Override
	public String getNvtOid() {
        return this.mNvtOid;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getPort()
	 */
    @Override
    public String getPort() {
        return this.mPort;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getResultId()
	 */
    @Override
	public String getResultId() {
        return this.mResultId;
    }

    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getRiskFactor()
	 */
    @Override
	public String getRiskFactor() {
        return this.mRiskFactor.name();
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getSubnet()
	 */
    @Override
    public String getSubnet() {
        return this.mSubnet;
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getThreat()
	 */
    @Override
	public String getThreat() {
        return this.mThreat.name();
    }
    
    /* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getCve()
	 */
    @Override
    public String getCve() {
        return this.mCve;
    }

	/* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getDetectTimestamp()
	 */
	@Override
	public Timestamp getDetectTimestamp() {
		return this.detectTime;
	}


	/* (non-Javadoc)
	 * @see de.hshannover.f4.trust.ironevents.ironvas.implementations.IronvasEvent#getCreateTimestamp()
	 */
	@Override
	public Timestamp getCreateTimestamp() {
		return this.createTime;
	}
	

}
