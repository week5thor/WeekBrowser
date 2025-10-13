package com.a525team.weekbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

import java.io.UnsupportedEncodingException;
import java.io.ByteArrayInputStream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdBlocker {
	private final Map<String, Boolean> blockedHosts = new ConcurrentHashMap<>();
	private final Map<String, Boolean> blockedUrls = new ConcurrentHashMap<>();
	private static AdBlocker instance;
	private Context context;
	
	public AdBlocker(Context context) {
		this.context = context;
		loadBlockedHosts(context);
	}
	
	public static synchronized AdBlocker getInstance(Context context) {
		if (instance == null) {
			instance = new AdBlocker(context);
		}
		return instance;
	}
	
	public void loadBlockedHosts(Context context) {
		blockedHosts.clear();
		blockedUrls.clear();
		loadBlockedHostsFromSharedPreferences(context);
		loadStdBlockedHosts(context);
	}
	
	private void loadBlockedHostsFromSharedPreferences(Context context) {
		SharedPreferences sharedPreferences = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
		String adHosts = sharedPreferences.getString("adhosts", "");
		if (adHosts != null && !adHosts.isEmpty()) {
			String[] lines = adHosts.split("\n");
			for (String line : lines) {
				line = line.trim();
				if (line.startsWith("#") || line.startsWith("//") || line.isEmpty()) {
					continue;
				}
				if (line.startsWith("%")) {
					blockedUrls.put(line.substring(1).trim(), true);
				} else {
					blockedHosts.put(line.trim(), true);
				}
			}
		}
	}
	
	private void loadStdBlockedHosts(Context context) {
		String stdAdList = stdadlist();
		String[] lines = stdAdList.split("\n");
		for (String line : lines) {
			line = line.trim();
			if (line.startsWith("#") || line.startsWith("//") || line.isEmpty()) {
				continue;
			}
			if (line.startsWith("%")) {
				blockedUrls.put(line.substring(1).trim(), true);
			} else {
				blockedHosts.put(line.trim(), true);
			}
		}
	}
	
	public boolean isBlocked(String url) {
		String domain = Uri.parse(url).getHost();
		if (domain == null) {
			return false;
		}
		for (String blockedHost : blockedHosts.keySet()) {
			if (domain.matches(".*" + blockedHost + ".*")) {
				return true;
			}
		}
		for (String blockedUrl : blockedUrls.keySet()) {
			if (url.matches(".*" + blockedUrl + ".*")) {
				return true;
			}
		}
		return false;
	}
	
	public static WebResourceResponse pseudoAd(String url){
		try{
			String mimeType = "text/plain";
			String content = "";
			if (url.endsWith(".js")) {
				mimeType = "application/javascript";
				content = "//";
			} else if (url.endsWith(".css")) {
				mimeType = "text/css";
				content = "/* */";
			} else if (url.endsWith(".html") || url.contains("iframe") || url.contains("adframe")) {
				mimeType = "text/html";
				content = "<html><body></body></html>";
			} else if (url.endsWith(".svg")) {
				mimeType = "image/svg+xml";
				content = "<svg xmlns='http://www.w3.org/2000/svg'></svg>";
			} else if (url.endsWith(".jpg") || url.endsWith(".jpeg")) {
				mimeType = "image/jpeg";
				return new WebResourceResponse(mimeType, "utf-8", new ByteArrayInputStream(new byte[]{(byte)0xFF, (byte)0xD8, (byte)0xFF}));
			} else if (url.endsWith(".png")) {
				mimeType = "image/png";
				return new WebResourceResponse(mimeType, "utf-8", new ByteArrayInputStream(new byte[]{(byte)0x89, 0x50, 0x4E, 0x47}));
			} else {
				// ¯\_(ツ)_/¯
			}
			
			return new WebResourceResponse(mimeType, "utf-8", new ByteArrayInputStream(content.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public boolean blockRedir() {
		SharedPreferences sharedPreferences = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
		int br = Integer.parseInt(sharedPreferences.getString("blockredir", "0"));
		int ba = Integer.parseInt(sharedPreferences.getString("blockad", "0"));
		return br==2 || (br == 1 && ba == 1);
	}
	
	private static final String AD_LIST = 
	"%youtube\\.com/ptracking\n" +
	"%youtube\\.com/generate\n" +
	"yt3\\.ggpht\\.com/ytc\n" +
	"%youtube\\.com/c\n" +
	"liftoff\n" +
	"clickadu\n" +
	"%yandex\\.ru/ads\n" +
	"betsxwin\n" +
	"lh4\\.googleusercontent\\.com\n" +
	"rekrut65\n" +
	"155-ombr\n" +
	"%bit\\.ly/.*brigade.*sofua\\.army\n" +
	"NewOtpSms\n" +
	"chatovi\\.online\n" +
	"koodukraine\\.tech\n" +
	"rec\\.dpsu\\.gov\\.ua\n" +
	"lyutnabir\n" +
	"\\.go\\.link\n" +
	"%if\\.ua/nova1\n" +
	"%brama_channel\n" +
	"stopfraud\n" +
	"%unmanned_systems\n" +
	"%12brigade_vacancies\n" +
	"droneline\\.army\n" +
	"usforces\\.army\n" +
	"anketa-lviv\n" +
	"omegasof\\.army\n" +
	"%Centr_omega_NGU\n" +
	"krkn\\.army\n" +
	"nadpsu\n" +
	"47\\.army\n" +
	"opfor\\.army\n" +
	"lfrecruiting\n" +
	"army\\.gov\n" +
	"pihota\\.army\n" +
	"terytoria\\.org\n" +
	"godshv\\.mil\n" +
	"npu\\.gov\n" +
	"dpsu\\.gov\n" +
	"mvs\\.gov\n" +
	"hotkredit\n" +
	"bg\\.in\\.ua\n" +
	"ua\\.if\\.ua\n" +
	"%bit\\.ly/3A43Y5L\n" +
	"%bit\\.ly/3AoP4XR\n" +
	"%bit\\.ly/40wYEmv\n" +
	"turbosms\\.ua\n" +
	"%bit\\.ly/4iGcYzI\n" +
	"%bit\\.ly/ontaxi_rcs\n" +
	"%bit\\.ly/43UpYug\n" +
	"%youtube\\.com/ptracking\n" +
	"clickadu\n" +
	"%google\\.com\\..*/ads\n" +
	"mygaru\n" +
	"fundingchoicesmessages\n" +
	"lijit\n" +
	"servenobid\n" +
	"creativecdn\n" +
	"4dex\n" +
	"onetag-sys\n" +
	"prebid\n" +
	"viibslav\n" +
	"betking\n" +
	"vegas\\.ua\n" +
	"lowtirtougaa\n" +
	"adsmoloco\n" +
	"kennedy-frazier\\.nicocas\\.my\n" +
	"vlog-konkursuaadw-track\n" +
	"topgenua\\.world\n" +
	"temu\n" +
	"trandgid\n" +
	"sr?v.*\\.com\n" +
	"ci3\\.googleusercontent\n" +
	"bitsdujour\n" +
	"cityclub\n" +
	"ashampoo\n" +
	"admixer\n" +
	"litres\n" +
	"lh6\\.googleusercontent\n" +
	"wisokykulas\n" +
	"rcvlink\n" +
	"i\\.4pda\\.ws\n" +
	"onewaywin\n" +
	"gamesport\n" +
	"ypls\n" +
	"prfl\n" +
	"cunta\n" +
	"arumo\n" +
	"cdnstatic\n" +
	"cosmobet\n" +
	"zpredir17\n" +
	"unityad\n" +
	"dalead\n" +
	"posix\n" +
	"premier1\n" +
	"gtblg\n" +
	"wwwhkinwa\n" +
	"google_vignette\n" +
	"forlifecode\n" +
	"bitcoin\\.site\n" +
	"nowuive\n" +
	"adtelligent\n" +
	"wiimguup\n" +
	"day\\.alerts\n" +
	"push-news\n" +
	"directrankcl\n" +
	"luckyorange\n" +
	"neloha\n" +
	"liga-koroliv\n" +
	"pub\\.network\n" +
	"hadron\n" +
	"%adclick\n" +
	"%doubleclick\n" +
	"stats\\.wp\n" +
	"freshmarketer\n" +
	"adsystem\n" +
	"%googlead\n" +
	"%advertising\n" +
	"%banner\n" +
	"%google_ad\n" +
	"%pagead\n" +
	"%googlesynd\n" +
	"%googletag\n" +
	"1xbet\n" +
	"favbet\n" +
	"d2wy8f7a9ursnm\n" +
	"casino\n" +
	"pncloudfl\n" +
	"vbet\n" +
	"loto\n" +
	"cloudfrale\n" +
	"oneclick\n" +
	"%analyti\n" +
	"%ashlyti\n" +
	"criteo\n" +
	"metric\n" +
	"hotjar\n" +
	"(pixel|an)\\.facebook\n" +
	"adcolony\n" +
	"777\n" +
	"sentry\n" +
	"bugsnag\n" +
	"pari\n" +
	"monoslot\n" +
	"melbet\n" +
	"loot\\.bet\n" +
	"loto-zoloto\\.net\n" +
	"lottoland\\.com\n" +
	"legzocasinoua\\.com\n" +
	"legzo\\.casino\n" +
	"leon\\.bet\n" +
	"kalmar-ukr-shop\n" +
	"icanshop\n" +
	"helpukr\n" +
	"ct.*\\.biz\n" +
	"cr.*\\.biz\n" +
	"wwbm\n" +
	"lkcl\n" +
	"jsc\\.mgid\n" +
	"help24\n" +
	"epidtrymka\n" +
	"bitz-play\n" +
	"go\\.redav\n" +
	"w\\.news\n" +
	"europeanchallengeukraine\n" +
	"dragongold88\n" +
	"derjavaukraine\n" +
	"clubdeluxe\\.net\n" +
	"coins\\.game\n" +
	"cashalot\\.bet\n" +
	"bitfinexgroup\n" +
	"dopomoga\n" +
	"blockchain4ukraine\n" +
	"betwinner\n" +
	"bet-boom\n" +
	"97jokerua\n" +
	"100bankiv\n" +
	"24uadopomoga\n" +
	"23konkurs\n" +
	"15jokerua\n" +
	"imasdk\n" +
	"8slottica\n" +
	"7goxbet\n" +
	"slotscity\n" +
	"lucky-wheel\n" +
	"%cummerata\n" +
	"%trafficjunk\n" +
	"supergra\n" +
	"givemelink\n" +
	"steepto\n" +
	"mixadvert\n" +
	"servetraff\n" +
	"freecontent\n" +
	"coinimp\n" +
	"hostingcloud\n" +
	"jquery-cdn\n" +
	"jqwww\n" +
	"heroku\n" +
	"rand\\.com\n" +
	"nablabee\n" +
	"webmine\n" +
	"vuryua\n" +
	"contaboserver\n" +
	"webassembly\\.stream\n" +
	"mining\n" +
	"miner\n" +
	"sunnimiq\n" +
	"minr\n" +
	"serv1swork\n" +
	"srcip\n" +
	"stonecalcom\n" +
	"flashx\n" +
	"nimiq\n" +
	"hostcontent\n" +
	"scaleway\n" +
	"pampopholf\n" +
	"scaleway\n" +
	"rocks\\.io\n" +
	"rock\\.reauthenticator\n" +
	"rock2\\.authcaptcha\n" +
	"vidzi\n" +
	"play\\.play\n" +
	"play\\.on\n" +
	"play\\.tercabilis\n" +
	"play\\.video\n" +
	"pool\\.hws\n" +
	"pr0gram\n" +
	"premiumstats\n" +
	"proofly\n" +
	"proxy-can\n" +
	"gramombird\n" +
	"istlandoll\n" +
	"play\\.mine\n" +
	"play\\.nexioniect\n" +
	"play\\.estream\n" +
	"1q2w3\n" +
	"pema\n" +
	"acbp0020171456\n" +
	"ad-miner\n" +
	"adminer\n" +
	"aeros\n" +
	"afminer\n" +
	"analytics\n" +
	"andlache\n" +
	"anybest\n" +
	"api\\.inwemo\n" +
	"as\\.cfcdist\n" +
	"ashgrrwt\n" +
	"authedmine\n" +
	"authedmine\n" +
	"authedwebmine\n" +
	"autologica\n" +
	"axoncoho\n" +
	"bablace\n" +
	"bafybeidravcab5p3acvthxtwosm4rfpl4yypwwm52s7sazgxaezfzn5xn4\n" +
	"baiduccdn1\n" +
	"becanium\n" +
	"berateveng\n" +
	"besocial\n" +
	"bestcoinsignals\n" +
	"besti\n" +
	"bestsrv\n" +
	"bewaslac\n" +
	"biberukalap\n" +
	"binarybusiness\n" +
	"bitcoin-cashcard\n" +
	"bitcoin-pay\n" +
	"bitcoin-pocket\n" +
	"bmcm\n" +
	"bmcm\n" +
	"bmnr\n" +
	"bmst\n" +
	"candid\n" +
	"cashbeet\n" +
	"adless\n" +
	"cloudcoins\n" +
	"minescripts\n" +
	"pebx\n" +
	"cloudflane\n" +
	"cfcdist\n" +
	"clgserv\n" +
	"cloud-miner\n" +
	"cloudcdn\n" +
	"cnhv\n" +
	"cnt\\.statistic\n" +
	"coin-have\n" +
	"coinblind\n" +
	"coinerra\n" +
	"coinnebula\n" +
	"coinpirate\n" +
	"coinpot\n" +
	"coinrail\n" +
	"contribute\\.to\n" +
	"cryptaloot\n" +
	"crypto-loot\n" +
	"crypto\\.csgocpu\n" +
	"cryptoloot\n" +
	"cpufan\n" +
	"dark-utilities\n" +
	"de-mi\n" +
	"de-ner\n" +
	"depttake\n" +
	"digger\n" +
	"cryptobara\n" +
	"browsermine\n" +
	"donttbeevils\n" +
	"dronml\n" +
	"easyhash\n" +
	"eth-pocket\n" +
	"xlivrdr\n" +
	"afcdn\n" +
	"pncloudfl\n" +
	"tsyndicate\n" +
	"erling\\.online\n" +
	"hotline\\.finance\n" +
	"skated\\.co\n" +
	"djeefhdbjdfacgcfac\\.world\n" +
	"wmgtr\\.com\n" +
	"kl89regular\n" +
	"s\\.schulist\\.link";
	
	private String stdadlist() {
		return AD_LIST;
	}
}
