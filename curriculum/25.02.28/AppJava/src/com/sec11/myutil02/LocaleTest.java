package com.sec11.myutil02;

import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		// Locale m_locale = Locale.getDefault();
		Locale m_locale = Locale.CANADA_FRENCH;
		System.out.println("  Language, Country, Variant, Name");
		System.out.println("Default locale: ");
		System.out.println("   " + m_locale.getLanguage() + ", "
				+ m_locale.getCountry() + ", " + m_locale.getVariant() + ", "
				+ m_locale.getDisplayName());

	
		}
	}

