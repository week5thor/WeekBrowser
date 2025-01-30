package com.a525team.weekbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Set;

public class AdBlocker {
    private final Set<String> blockedHosts = new HashSet<>();
    private final Set<String> blockedUrls = new HashSet<>();

    public AdBlocker(Context context) {
        loadBlockedHosts(context);
    }

    private void loadBlockedHosts(Context context) {
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
                    blockedUrls.add(line.substring(1).trim());
                } else {
                    blockedHosts.add(line.trim());
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
                blockedUrls.add(line.substring(1).trim());
            } else {
                blockedHosts.add(line.trim());
            }
        }
    }

    public boolean isBlocked(String url) {
        String domain = Uri.parse(url).getHost();
        if (domain == null) {
            return false;
        }
        for (String blockedHost : blockedHosts) {
            if (domain.matches(".*" + blockedHost + ".*")) {
                return true;
            }
        }
        for (String blockedUrl : blockedUrls) {
            if (url.matches(".*" + blockedUrl + ".*")) {
                return true;
            }
        }
        return false;
    }

private String stdadlist(){
    return ("trandgid\nsr?v.*\\.com\nci3\\.googleusercontent\nbitsdujour\ncityclub\nashampoo\nadmixer\nlitres\nlh6\\.googleusercontent\nwisokykulas\nrcvlink\ni\\.4pda\\.ws\nonewaywin\ngamesport\nypls\nprfl\ncunta\narumo\ncdnstatic\ncosmobet\nzpredir17\nunityad\ndalead\nposix\npremier1\ngtblg\nwwwhkinwa\ngoogle_vignette\nforlifecode\nbitcoin\\.site\nnowuive\nadtelligent\nwiimguup\nday\\.alerts\npush-news\ndirectrankcl\nluckyorange\nneloha\nliga-koroliv\npub\\.network\nhadron\n%adclick\n%doubleclick\nstats\\.wp\nfreshmarketer\nadsystem\n%googlead\n%advertising\n%banner\n%google_ad\n%pagead\n%googlesynd\n%googletag\n1xbet\nfavbet\nd2wy8f7a9ursnm\ncasino\npncloudfl\nvbet\nloto\ncloudfrale\noneclick\n%analyti\n%ashlyti\ncriteo\nmetric\nhotjar\n(pixel|an)\\.facebook\nadcolony\n777\nsentry\nbugsnag\npari\nmonoslot\nmelbet\nloot\\.bet\nloto-zoloto\\.net\nlottoland\\.com\nlegzocasinoua\\.com\nlegzo\\.casino\nleon\\.bet\nkalmar-ukr-shop\nicanshop\nhelpukr\nct.*\\.biz\ncr.*\\.biz\nwwbm\nlkcl\njsc\\.mgid\nhelp24\nepidtrymka\nbitz-play\ngo\\.redav\nw\\.news\neuropeanchallengeukraine\ndragongold88\nderjavaukraine\nclubdeluxe\\.net\ncoins\\.game\ncashalot\\.bet\nbitfinexgroup\ndopomoga\nblockchain4ukraine\nbetwinner\nbet-boom\n97jokerua\n100bankiv\n24uadopomoga\n23konkurs\n15jokerua\nimasdk\n8slottica\n7goxbet\nslotscity\nlucky-wheel\n%cummerata\n%trafficjunk\nsupergra\ngivemelink\nsteepto\nmixadvert\nservetraff\nfreecontent\ncoinimp\nhostingcloud\njquery-cdn\njqwww\nheroku\nrand\\.com\nnablabee\nwebmine\nvuryua\ncontaboserver\nwebassembly\\.stream\nmining\nminer\nsunnimiq\nminr\nserv1swork\nsrcip\nstonecalcom\nflashx\nnimiq\nhostcontent\nscaleway\npampopholf\nscaleway\nrocks\\.io\nrock\\.reauthenticator\nrock2\\.authcaptcha\nvidzi\nplay\\.play\nplay\\.on\nplay\\.tercabilis\nplay\\.video\npool\\.hws\npr0gram\npremiumstats\nproofly\nproxy-can\ngramombird\nistlandoll\nplay\\.mine\nplay\\.nexioniect\nplay\\.estream\n1q2w3\npema\nacbp0020171456\nad-miner\nadminer\naeros\nafminer\nanalytics\nandlache\nanybest\napi\\.inwemo\nas\\.cfcdist\nashgrrwt\nauthedmine\nauthedmine\nauthedwebmine\nautologica\naxoncoho\nbablace\nbafybeidravcab5p3acvthxtwosm4rfpl4yypwwm52s7sazgxaezfzn5xn4\nbaiduccdn1\nbecanium\nberateveng\nbesocial\nbestcoinsignals\nbesti\nbestsrv\nbewaslac\nbiberukalap\nbinarybusiness\nbitcoin-cashcard\nbitcoin-pay\nbitcoin-pocket\nbmcm\nbmcm\nbmnr\nbmst\ncandid\ncashbeet\nadless\ncloudcoins\nminescripts\npebx\ncloudflane\ncfcdist\nclgserv\ncloud-miner\ncloudcdn\ncnhv\ncnt\\.statistic\ncoin-have\ncoinblind\ncoinerra\ncoinhiveproxy\ncoinnebula\ncoinpirate\ncoinpot\ncoinrail\ncontribute\\.to\ncryptaloot\ncrypto-loot\ncrypto\\.csgocpu\ncryptoloot\ncpufan\ndark-utilities\nde-mi\nde-ner\ndepttake\ndigger\ncryptobara\nbrowsermine\ndonttbeevils\ndronml\neasyhash\neth-pocket\nxlivrdr\nafcdn\npncloudfl\ntsyndicate\nerling\\.online\nhotline\\.finance\nyt3\\.ggpht\\.com\nskated\\.co\ndjeefhdbjdfacgcfac\\.world\nwmgtr\\.com\nkl89regular\ns\\.schulist\\.link");
    }

}







