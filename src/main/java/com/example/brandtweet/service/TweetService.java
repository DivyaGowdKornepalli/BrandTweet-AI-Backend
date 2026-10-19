
package com.example.brandtweet.service;

import org.springframework.stereotype.Service;

import com.example.brandtweet.model.TweetRequest;
import com.example.brandtweet.model.TweetResponse;

@Service
public class TweetService {

    public TweetResponse generateTweets(TweetRequest request) {

        String brandName = getValue(
                request.getBrandName(), "Our Brand");

        String industry = getValue(
                request.getIndustry(), "General");

        String objective = getValue(
                request.getObjective(), "Increase brand awareness");

        String productDetails = getValue(
                request.getProductDetails(), "Our products and services");

        StringBuilder result = new StringBuilder();

        // Brand voice summary
        result.append("BRAND VOICE SUMMARY\n\n");

        result.append("• Tone: Friendly, engaging, and informative.\n");
        result.append("• Target audience: People interested in ")
              .append(industry).append(".\n");
        result.append("• Content themes: Product awareness, benefits, ")
              .append("customer engagement, and brand identity.\n");
        result.append("• Campaign focus: ")
              .append(objective).append(".\n\n");

        // Tweet generation
        result.append("TWEETS\n\n");

        String[] tweets = {
            "Discover what makes %s stand out in %s! "
                + "Explore our offerings and join the conversation. #BrandAwareness",

            "Looking for something related to %s? "
                + "%s is here to help you explore your options.",

            "Every brand has a story. Get to know %s "
                + "and discover what we bring to %s. #OurStory",

            "Your interests matter! Tell us what you look for "
                + "in %s. We would love to hear from you. #YourVoice",

            "A closer look at %s: %s. "
                + "Learn more and see if it fits your needs.",

            "Let's talk about %s! What matters most to you "
                + "when choosing a product or service? #Community",

            "Stay connected with %s for updates, ideas, "
                + "and more from the world of %s.",

            "Great conversations start with great questions. "
                + "What would you like to know about %s? #AskUs",

            "Exploring %s? Make %s part of your discovery. "
                + "Share your thoughts with us!",

            "Thanks for being part of the %s community! "
                + "Follow along as we continue working toward %s."
        };

        for (int i = 0; i < tweets.length; i++) {

            String tweet = switch (i) {
                case 0 -> String.format(
                        tweets[i], brandName, industry);

                case 1 -> String.format(
                        tweets[i], industry, brandName);

                case 2 -> String.format(
                        tweets[i], brandName, industry);

                case 3 -> String.format(
                        tweets[i], industry);

                case 4 -> String.format(
                        tweets[i], brandName, productDetails);

                case 5 -> String.format(
                        tweets[i], industry);

                case 6 -> String.format(
                        tweets[i], brandName, industry);

                case 7 -> String.format(
                        tweets[i], brandName);

                case 8 -> String.format(
                        tweets[i], industry, brandName);

                default -> String.format(
                        tweets[i], brandName, objective);
            };

            result.append(i + 1)
                  .append(". ")
                  .append(tweet)
                  .append("\n\n");
        }

        return new TweetResponse(result.toString());
    }

    private String getValue(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }

        return value.trim();
    }
}
