/**
 * Copyright 2021 Voyta Krizek, https://github.com/NewTownData
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.newtowndata.osmismerka;

/**
 *
 * @author Voyta Krizek, https://github.com/NewTownData
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// input = (CZ) pole osmismerky
		// input = (EN) area of the word puzzle
		String input = "PECÍLPSTŘEDNÍKK " + "AAKNETSÍMHRVZOR " + "RNAŘETENRSOZEUE " + "AAKČADÁLKBONTŘT "
				+ "PŘÍVĚSEŘUDAIIOR " + "ENÁPADÍRANRLKVU " + "TRNKAŇZPKDÁÁAOH " + "THERNAMELGNUŽDL "
				+ "AKNAHUORTSTUŽKA " + "KÁNAPRŮKAZKABMA";

		// dict = (CZ) hledana slova pro osmismerku
		// dict = (EN) list for the puzzle
		String dict = "BALADA BUNDA BURZA DRÁŽKA DŽUNGLE ETIKA HERNA KOUŘOVOD KREDENC "
				+ "MÍSTENKA NÁPAD NETEŘ OBKLÁDAČKA PANÁK PARAPET PLÍCE PŘÍVĚS PRŮKAZKA "
				+ "PUMPA ROZVRH SKŘÍŇ STŘEDNÍK STROUHANKA STUŽKA TRÁVA TRNKA TRUHLA";

		Solver s = new Solver();
		long time = System.currentTimeMillis();
		String result = s.solve(input, dict);
		long done = System.currentTimeMillis();
		System.out.println(result + " (in " + (done - time) + " ms)");

		input = "AVĚTŠVÁNTOAAUTOBUSPE\n" + "TFNPEČAJNÍKMDENDÁAŘI\n" + "OUÍADRESAIIRCÁAŇNTEM\n"
				+ "MNAHAKAPLESOÍHKÉČETO\n" + "AKBODÁNBLEOFDYRSDZVN\n" + "SCOAKLUBATČODGĚUAAÁO\n"
				+ "CESTOPISNKINIITVPKŘK\n" + "ÉOOŮELÁNAKNMAEŠEDÍKE\n" + "NMHROZBAROŽVGNENOJAL\n"
				+ "ALEKCEĚDHEÁANAJÝLAFD\n" + "MUNICEÍKBSKKÓTTRÁČII\n" + "AVÁŤŠVOŮMČOLZDRÁHAGŽ\n"
				+ "DELEKTROINSTALACENUK\n" + "ZNEAODKLJVITOMSKVVRO\n" + "ÁKPPEIUESELKOPAUAOAN\n"
				+ "RAKÍNILHFOANREHCŠLNT\n" + "BVAGVETĚVEIGOLOKEÁTR\n" + "ŠÉFKAKTNATNEZERPERKO\n"
				+ "DIPLOMÍŮOLGYMNASTKAL\n" + "ŽEDÁRKPRÁZDNINYDESKA";
		dict = "ADRESA AUTOBUS BRÁZDA ČAJÍK ČAJNÍK CESTOPIS CHRUP ČINŽÁK DATLOVNÍK DESKA DIAGNÓZA "
				+ "DIPLOM DÍVKA DRÁHA DRŮBEŽ EFEKT EKOLOGIE EKONOMIE ELEKTROINSTALACE FIGURANTKA FORMA "
				+ "FUNKCE GYMNASTKA HERNA HLINÍK HRANA HROZBA HYGIENA JEŠTĚRKA KABARET KAHAN KANÁL KAPLE "
				+ "KASKÁDA KAZETA KONTROLA KRÁDEŽ KRÁLOVNA KRŮTA LÁHEV LEKCE MIGRÉNA MONITOR MOTIV MUNICE "
				+ "NÁDOBKA NÁLEPKA NÁVŠTĚVA ODHAD ODPAD OMLUVENKA OSIKA OSOBA OTLAK POKLES POTOK PRÁZDNINY "
				+ "PŘETVÁŘKA REKLAMACE REPREZENTANTKA REPUBLIKA SAMOTA SÁŇKY SCÉNA ŠÉFKA SLEČNA SMOKING "
				+ "ŠPÍNA ŠŤÁVA SUŠÁK SUVENÝR TABULKA TRASA ULIČKA VĚTEV ŽIDLE";

		time = System.currentTimeMillis();
		result = s.solve(input, dict);
		done = System.currentTimeMillis();
		System.out.println(result + " (in " + (done - time) + " ms)");

		input = "KÍNVOLTADGRAMATIKAFH\n" + "SKRÁLÍKÁRNATKNOIDATS\n" + "NTKEFEDŘEKRMŘČNLSALB\n"
				+ "ĚESDVOŇEDOVOPÍAÁHVNR\n" + "ŽAMÁLSLMFČASVHDKCAOO\n" + "EXPEDICENÁUFAAĚAELFK\n"
				+ "NHUMORJNCRJÉOKJUDSOO\n" + "KTORKNABBOPREPEZÁORL\n" + "ANÉCSABURŽOAZIEANAKI\n"
				+ "KAÁHĚDCDTZNINŠRRKKIC\n" + "ŠMRAZNIČKAPSLEITAPME\n" + "AAKLKOYVRCZAJULTEUAE\n"
				+ "TIEOOSĚHAILZPESÁDLTM\n" + "ODTUKTEKOMEDIEETKSEU\n" + "MVIPONÉDMBTGCPRPREKB\n"
				+ "ASKKSTÍPĚÁOKOŠILKAUL\n" + "SOAAORĚMOLHÚRLATAHCA\n" + "PLUPŘÍCHODBAKČIBYHCE\n"
				+ "AZYLANTKAKŤALIMUZÍNA\n" + "KHMUŠLEKAMARÁDKAMLEŠ";
		dict = "ALBUM ATMOSFÉRA AZYLANTKA BANKROT BELETRIE BOHYNĚ BROKOLICE BURŽOAZIE CELOFÁN CESTA "
				+ "CHALOUPKA CHATA CHYBIČKA CIMBÁL CUKETA DATLOVNÍK DEFEKT DĚLBA DESKA DIAMANT DLAHA "
				+ "EKOLOGIE EMPATIE ETIKA EXPEDICE FASÁDA FJORD GRAMATIKA HOTEL HRANA HUMOR HYPOTÉKA "
				+ "ILUSTRACE JAVOR KAMARÁDKA KAPSA KAPSLE KAUZA KOČÁR KOKOS KOMEDIE KOMÍN KOŠILKA KOTVA "
				+ "KRÁLÍKÁRNA KRČMA LAŤKA LIMUZÍNA MAPKA MIKROFON MRAZNIČKA MUŠLE NÁDECH NADĚJE OPERA "
				+ "OSLAVA PANELÁK PERLA PILKA PIZZA POVODEŇ PŘÍCHOD ŘEMEN ROZKVĚT SÁDRA SAMOTA SCÉNA "
				+ "SEKAČKA ŠELMA ŠIPKA SLÁMA SLUPKA SNĚŽENKA SONDA STADION TAŠKA TŘÍDA TROFEJ UBRUS ÚHLOMĚR";

		time = System.currentTimeMillis();
		result = s.solve(input, dict);
		done = System.currentTimeMillis();
		System.out.println(result + " (in " + (done - time) + " ms)");
	}

}
