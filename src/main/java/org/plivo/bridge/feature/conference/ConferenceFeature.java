package org.plivo.bridge.feature.conference;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-08-22
 * @author Paulo reis
 */

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.plivo.bridge.client.PlivoClient;
import org.plivo.bridge.exception.PlivoClientException;
import org.plivo.bridge.feature.base.BaseFeature;
import org.plivo.bridge.to.response.conference.ConferenceDeafResponse;
import org.plivo.bridge.to.response.conference.ConferenceHangupResponse;
import org.plivo.bridge.to.response.conference.ConferenceKickResponse;
import org.plivo.bridge.to.response.conference.ConferenceListResponse;
import org.plivo.bridge.to.response.conference.ConferenceMuteResponse;
import org.plivo.bridge.to.response.conference.ConferencePlayResponse;
import org.plivo.bridge.to.response.conference.ConferenceRecordStartResponse;
import org.plivo.bridge.to.response.conference.ConferenceRecordStopResponse;
import org.plivo.bridge.to.response.conference.ConferenceSpeakResponse;
import org.plivo.bridge.to.response.conference.ConferenceUndeafResponse;
import org.plivo.bridge.to.response.conference.ConferenceUnmuteResponse;
import org.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class ConferenceFeature extends BaseFeature {

	public ConferenceFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
		this.setBaseResource(this.getBaseResource());
	}

	// /v1/Account/{auth_id}/Conference/
	public String getAll() 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.get(String.class);

					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_id}/
	public String getOne(String ConferenceId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.get(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	//  /v1/Account/{auth_id}/Conference/
	public String hangupAll() 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.delete(String.class);

					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_id}/
	public String hangupOne(String ConferenceId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
							.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/")
							.type(MediaType.APPLICATION_JSON_TYPE)
							.accept(MediaType.APPLICATION_JSON_TYPE)
							.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/
	public String hangupOneMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}		


	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Play/
	public String playToMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Play/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Play/
	public String stopPlayToMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Play/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Speak/
	public String speakToMember(String ConferenceId, String MemberId, Map<String, String> parameters) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Speak/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class, PlivoUtils.ParameterUtils.mapToJSON(parameters));
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}


	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Deaf/
	public String deafMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Deaf/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Deaf/
	public String unDeafMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Deaf/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Mute/
	public String muteMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Mute/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}

	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Mute/
	public String unMuteMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Mute/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.delete(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}
	
	// /v1/Account/{auth_id}/Conference/{conference_id}/Member/{member_id}/Kick/

	public String kickMember(String ConferenceId, String MemberId) 
			throws PlivoClientException {

				try {
					String response = this.getBaseResource()
						.path("/Account/"+this.getAccountId()+"/Conference/"+ConferenceId+"/Member"+MemberId+"/Kick/")
						.type(MediaType.APPLICATION_JSON_TYPE)
						.accept(MediaType.APPLICATION_JSON_TYPE)
						.post(String.class);
							
					return response;
				} catch (UniformInterfaceException e) {
					throw new PlivoClientException(e);
				}
			}
}
