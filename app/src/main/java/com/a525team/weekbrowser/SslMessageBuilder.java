package com.a525team.weekbrowser;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslCertificate;

public class SslMessageBuilder {

    public static String build(Context context, String url, SslCertificate cert, String errorCode) {
        StringBuilder sb = new StringBuilder();
        boolean safe = true;

        if (url != null && url.startsWith("http:")) {
            sb.append("⚠️ ").append(context.getString(R.string.warnhttp)).append("\n\n");
            safe = false;
        } else if (url != null && url.startsWith("https:")) {
            if (errorCode != null) {
                safe = false;
                sb.append("⚠️ ").append(context.getString(R.string.pageunsecure)).append("\n\n");
                sb.append("❗ ").append(context.getString(R.string.ssl_error_prefix)).append(" ");

                if (errorCode.contains("SSL_EXPIRED")) sb.append(context.getString(R.string.ssl_error_expired));
                else if (errorCode.contains("SSL_UNTRUSTED")) sb.append(context.getString(R.string.ssl_error_untrusted));
                else if (errorCode.contains("SSL_IDMISMATCH")) sb.append(context.getString(R.string.ssl_error_mismatch));
                else if (errorCode.contains("SSL_DATE_INVALID")) sb.append(context.getString(R.string.ssl_error_date_invalid));
                else if (errorCode.contains("SSL_NOTYETVALID")) sb.append(context.getString(R.string.ssl_error_not_yet));
                else sb.append(context.getString(R.string.ssl_error_generic)).append("(").append(errorCode).append(")");

                sb.append("\n────────\n");
            }

            if (cert != null) {
                SslCertificate.DName issuedTo = cert.getIssuedTo();
                SslCertificate.DName issuedBy = cert.getIssuedBy();
                String validUntil = cert.getValidNotAfterDate().toLocaleString();

                if (safe) sb.append("✅ ").append(context.getString(R.string.pagesecure)).append("\n\n");

                sb.append("📌 ").append(context.getString(R.string.issuedto)).append("\n");
                sb.append(context.getString(R.string.organization)).append(" ").append(issuedTo.getOName()).append("\n");
                sb.append(context.getString(R.string.cname)).append(" ").append(issuedTo.getCName()).append("\n\n");

                sb.append("🛡️ ").append(context.getString(R.string.issuedby)).append("\n");
                sb.append(issuedBy.getOName()).append("\n\n");

                sb.append("📅 ").append(context.getString(R.string.validuntil)).append("\n");
                sb.append(validUntil);
            } else {
                sb.append("⚠️ ").append(context.getString(R.string.pageunsecure));
                safe = false;
            }
        } else {
            sb.append("✅ ").append(context.getString(R.string.dontneed));
        }

        if (!safe) sb.append("\n\n🛑 ").append(context.getString(R.string.safetywarning));

        return sb.toString();
    }
}