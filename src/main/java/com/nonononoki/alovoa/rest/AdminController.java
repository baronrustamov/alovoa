package com.nonononoki.alovoa.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nonononoki.alovoa.model.AdminAccountDeleteDto;
import com.nonononoki.alovoa.model.AlovoaException;
import com.nonononoki.alovoa.model.MailDto;
import com.nonononoki.alovoa.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/report/delete/{id}")
	public void deleteReport(@PathVariable long id) throws AlovoaException {
		adminService.deleteReport(id);
	}

	@PostMapping("/ban-user/{id}")
	public void banUser(@PathVariable String id)
			throws NumberFormatException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, AlovoaException {
		adminService.banUser(id);
	}

	@PostMapping("/remove-images/{id}")
	public void removeImages(@PathVariable String id)
			throws NumberFormatException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, AlovoaException {
		adminService.removeImages(id);
	}

	@PostMapping("/remove-description/{id}")
	public void removeDescription(@PathVariable String id)
			throws NumberFormatException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, AlovoaException {
		adminService.removeDescription(id);
	}

	@PostMapping("/contact/hide/{id}")
	public void hideContact(@PathVariable long id) throws AlovoaException {
		adminService.hideContact(id);
	}

	@PostMapping(value = "/mail/single", consumes = "application/json")
	public void sendMailSingle(@RequestBody MailDto dto) throws AlovoaException, MessagingException, IOException {
		adminService.sendMailSingle(dto);
	}

	@PostMapping(value = "/mail/all", consumes = "application/json")
	public void sendMailAll(@RequestBody MailDto dto) throws AlovoaException, MessagingException, IOException {
		adminService.sendMailAll(dto);
	}

	@PostMapping(value = "/delete-account", consumes = "application/json")
	public void deleteAccount(@RequestBody AdminAccountDeleteDto dto) throws AlovoaException {
		adminService.deleteAccount(dto);
	}

	@PostMapping("/user-exists/{email}")
	public boolean userExists(@PathVariable String email) throws AlovoaException, UnsupportedEncodingException {
		return adminService.userExists(email);
	}

	@PostMapping("/donation/add/{email}/{amount}")
	public void addDonation(@PathVariable String email, @PathVariable double amount)
			throws AlovoaException, UnsupportedEncodingException {
		adminService.addDonation(email, amount);
	}

}
