namespace QuickType
{
    using System;
    using System.Collections.Generic;

    using System.Globalization;
    using Newtonsoft.Json;
    using Newtonsoft.Json.Converters;

    public partial class ApiEspacio
    {
        [JsonProperty("docs")]
        public Doc[] Docs { get; set; }

        [JsonProperty("totalDocs")]
        public long TotalDocs { get; set; }

        [JsonProperty("offset")]
        public long Offset { get; set; }

        [JsonProperty("limit")]
        public long Limit { get; set; }

        [JsonProperty("totalPages")]
        public long TotalPages { get; set; }

        [JsonProperty("page")]
        public long Page { get; set; }

        [JsonProperty("pagingCounter")]
        public long PagingCounter { get; set; }

        [JsonProperty("hasPrevPage")]
        public bool HasPrevPage { get; set; }

        [JsonProperty("hasNextPage")]
        public bool HasNextPage { get; set; }

        [JsonProperty("prevPage")]
        public object PrevPage { get; set; }

        [JsonProperty("nextPage")]
        public long NextPage { get; set; }
    }

    public partial class Doc
    {
        [JsonProperty("fairings")]
        public Fairings Fairings { get; set; }

        [JsonProperty("links")]
        public Links Links { get; set; }

        [JsonProperty("static_fire_date_utc")]
        public DateTimeOffset? StaticFireDateUtc { get; set; }

        [JsonProperty("static_fire_date_unix")]
        public long? StaticFireDateUnix { get; set; }

        [JsonProperty("net")]
        public bool Net { get; set; }

        [JsonProperty("window")]
        public long Window { get; set; }

        [JsonProperty("rocket")]
        public Rocket Rocket { get; set; }

        [JsonProperty("success")]
        public bool Success { get; set; }

        [JsonProperty("failures")]
        public Failure[] Failures { get; set; }

        [JsonProperty("details")]
        public string Details { get; set; }

        [JsonProperty("crew")]
        public object[] Crew { get; set; }

        [JsonProperty("ships")]
        public string[] Ships { get; set; }

        [JsonProperty("capsules")]
        public string[] Capsules { get; set; }

        [JsonProperty("payloads")]
        public string[] Payloads { get; set; }

        [JsonProperty("launchpad")]
        public Launchpad Launchpad { get; set; }

        [JsonProperty("flight_number")]
        public long FlightNumber { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("date_utc")]
        public DateTimeOffset DateUtc { get; set; }

        [JsonProperty("date_unix")]
        public long DateUnix { get; set; }

        [JsonProperty("date_local")]
        public DateTimeOffset DateLocal { get; set; }

        [JsonProperty("date_precision")]
        public DatePrecision DatePrecision { get; set; }

        [JsonProperty("upcoming")]
        public bool Upcoming { get; set; }

        [JsonProperty("cores")]
        public Core[] Cores { get; set; }

        [JsonProperty("auto_update")]
        public bool AutoUpdate { get; set; }

        [JsonProperty("tbd")]
        public bool Tbd { get; set; }

        [JsonProperty("launch_library_id")]
        public object LaunchLibraryId { get; set; }

        [JsonProperty("id")]
        public string Id { get; set; }
    }

    public partial class Core
    {
        [JsonProperty("core")]
        public string CoreCore { get; set; }

        [JsonProperty("flight")]
        public long Flight { get; set; }

        [JsonProperty("gridfins")]
        public bool Gridfins { get; set; }

        [JsonProperty("legs")]
        public bool Legs { get; set; }

        [JsonProperty("reused")]
        public bool Reused { get; set; }

        [JsonProperty("landing_attempt")]
        public bool LandingAttempt { get; set; }

        [JsonProperty("landing_success")]
        public bool? LandingSuccess { get; set; }

        [JsonProperty("landing_type")]
        public string LandingType { get; set; }

        [JsonProperty("landpad")]
        public object Landpad { get; set; }
    }

    public partial class Failure
    {
        [JsonProperty("time")]
        public long Time { get; set; }

        [JsonProperty("altitude")]
        public long? Altitude { get; set; }

        [JsonProperty("reason")]
        public string Reason { get; set; }
    }

    public partial class Fairings
    {
        [JsonProperty("reused")]
        public bool? Reused { get; set; }

        [JsonProperty("recovery_attempt")]
        public bool? RecoveryAttempt { get; set; }

        [JsonProperty("recovered")]
        public bool? Recovered { get; set; }

        [JsonProperty("ships")]
        public object[] Ships { get; set; }
    }

    public partial class Links
    {
        [JsonProperty("patch")]
        public Patch Patch { get; set; }

        [JsonProperty("reddit")]
        public Reddit Reddit { get; set; }

        [JsonProperty("flickr")]
        public Flickr Flickr { get; set; }

        [JsonProperty("presskit")]
        public Uri Presskit { get; set; }

        [JsonProperty("webcast")]
        public Uri Webcast { get; set; }

        [JsonProperty("youtube_id")]
        public string YoutubeId { get; set; }

        [JsonProperty("article")]
        public Uri Article { get; set; }

        [JsonProperty("wikipedia")]
        public Uri Wikipedia { get; set; }
    }

    public partial class Flickr
    {
        [JsonProperty("small")]
        public object[] Small { get; set; }

        [JsonProperty("original")]
        public object[] Original { get; set; }
    }

    public partial class Patch
    {
        [JsonProperty("small")]
        public Uri Small { get; set; }

        [JsonProperty("large")]
        public Uri Large { get; set; }
    }

    public partial class Reddit
    {
        [JsonProperty("campaign")]
        public object Campaign { get; set; }

        [JsonProperty("launch")]
        public Uri Launch { get; set; }

        [JsonProperty("media")]
        public object Media { get; set; }

        [JsonProperty("recovery")]
        public object Recovery { get; set; }
    }

    public enum DatePrecision { Hour };

    public enum Launchpad { The5E9E4501F509094Ba4566F84, The5E9E4502F509092B78566F87, The5E9E4502F5090995De566F86 };

    public enum Rocket { The5E9D0D95Eda69955F709D1Eb, The5E9D0D95Eda69973A809D1Ec };

    internal static class Converter
    {
        public static readonly JsonSerializerSettings Settings = new JsonSerializerSettings
        {
            MetadataPropertyHandling = MetadataPropertyHandling.Ignore,
            DateParseHandling = DateParseHandling.None,
            Converters =
            {
                DatePrecisionConverter.Singleton,
                LaunchpadConverter.Singleton,
                RocketConverter.Singleton,
                new IsoDateTimeConverter { DateTimeStyles = DateTimeStyles.AssumeUniversal }
            },
        };
    }

    internal class DatePrecisionConverter : JsonConverter
    {
        public override bool CanConvert(Type t) => t == typeof(DatePrecision) || t == typeof(DatePrecision?);

        public override object ReadJson(JsonReader reader, Type t, object existingValue, JsonSerializer serializer)
        {
            if (reader.TokenType == JsonToken.Null) return null;
            var value = serializer.Deserialize<string>(reader);
            if (value == "hour")
            {
                return DatePrecision.Hour;
            }
            throw new Exception("Cannot unmarshal type DatePrecision");
        }

        public override void WriteJson(JsonWriter writer, object untypedValue, JsonSerializer serializer)
        {
            if (untypedValue == null)
            {
                serializer.Serialize(writer, null);
                return;
            }
            var value = (DatePrecision)untypedValue;
            if (value == DatePrecision.Hour)
            {
                serializer.Serialize(writer, "hour");
                return;
            }
            throw new Exception("Cannot marshal type DatePrecision");
        }

        public static readonly DatePrecisionConverter Singleton = new DatePrecisionConverter();
    }

    internal class LaunchpadConverter : JsonConverter
    {
        public override bool CanConvert(Type t) => t == typeof(Launchpad) || t == typeof(Launchpad?);

        public override object ReadJson(JsonReader reader, Type t, object existingValue, JsonSerializer serializer)
        {
            if (reader.TokenType == JsonToken.Null) return null;
            var value = serializer.Deserialize<string>(reader);
            switch (value)
            {
                case "5e9e4501f509094ba4566f84":
                    return Launchpad.The5E9E4501F509094Ba4566F84;
                case "5e9e4502f509092b78566f87":
                    return Launchpad.The5E9E4502F509092B78566F87;
                case "5e9e4502f5090995de566f86":
                    return Launchpad.The5E9E4502F5090995De566F86;
            }
            throw new Exception("Cannot unmarshal type Launchpad");
        }

        public override void WriteJson(JsonWriter writer, object untypedValue, JsonSerializer serializer)
        {
            if (untypedValue == null)
            {
                serializer.Serialize(writer, null);
                return;
            }
            var value = (Launchpad)untypedValue;
            switch (value)
            {
                case Launchpad.The5E9E4501F509094Ba4566F84:
                    serializer.Serialize(writer, "5e9e4501f509094ba4566f84");
                    return;
                case Launchpad.The5E9E4502F509092B78566F87:
                    serializer.Serialize(writer, "5e9e4502f509092b78566f87");
                    return;
                case Launchpad.The5E9E4502F5090995De566F86:
                    serializer.Serialize(writer, "5e9e4502f5090995de566f86");
                    return;
            }
            throw new Exception("Cannot marshal type Launchpad");
        }

        public static readonly LaunchpadConverter Singleton = new LaunchpadConverter();
    }

    internal class RocketConverter : JsonConverter
    {
        public override bool CanConvert(Type t) => t == typeof(Rocket) || t == typeof(Rocket?);

        public override object ReadJson(JsonReader reader, Type t, object existingValue, JsonSerializer serializer)
        {
            if (reader.TokenType == JsonToken.Null) return null;
            var value = serializer.Deserialize<string>(reader);
            switch (value)
            {
                case "5e9d0d95eda69955f709d1eb":
                    return Rocket.The5E9D0D95Eda69955F709D1Eb;
                case "5e9d0d95eda69973a809d1ec":
                    return Rocket.The5E9D0D95Eda69973A809D1Ec;
            }
            throw new Exception("Cannot unmarshal type Rocket");
        }

        public override void WriteJson(JsonWriter writer, object untypedValue, JsonSerializer serializer)
        {
            if (untypedValue == null)
            {
                serializer.Serialize(writer, null);
                return;
            }
            var value = (Rocket)untypedValue;
            switch (value)
            {
                case Rocket.The5E9D0D95Eda69955F709D1Eb:
                    serializer.Serialize(writer, "5e9d0d95eda69955f709d1eb");
                    return;
                case Rocket.The5E9D0D95Eda69973A809D1Ec:
                    serializer.Serialize(writer, "5e9d0d95eda69973a809d1ec");
                    return;
            }
            throw new Exception("Cannot marshal type Rocket");
        }

        public static readonly RocketConverter Singleton = new RocketConverter();
    }
}
