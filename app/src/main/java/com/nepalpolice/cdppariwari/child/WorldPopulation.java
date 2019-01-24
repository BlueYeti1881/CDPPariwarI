package com.nepalpolice.cdppariwari.child;



public class WorldPopulation {
		private String contact_name;
	private String contact_mobile;
	private String contact_address;
	private String contact_email;
	private int contact_image;

	public WorldPopulation(String contact_name,String contact_mobile, String contact_address, String contact_email,
			int contact_image) {

		this.contact_name = contact_name;
		this.contact_mobile = contact_mobile;
		this.contact_address = contact_address;
		this.contact_email = contact_email;
		this.contact_image = contact_image;
	}


	public String getContact_name() {
		return this.contact_name;
	}

	public String getContact_mobile() {
		return this.contact_mobile;
	}

	public String getContact_address() {
		return this.contact_address;
	}


	public String getContact_email() {
		return this.contact_email;
	}

	public int getContact_image() {
		return this.contact_image;
	}
}
