nixpkgs: system: let
  makeOverlays = java: let
    ammoniteOverlay = final: prev: {
      ammonite = prev.ammonite.override {
        jre = final.${java};
      };
    };

    bloopOverlay = final: prev: {
      bloop = prev.bloop.override {
        jre = final.jre;
      };
    };

    millOverlay = final: prev: {
      mill = prev.mill.override {
        jre = final.jre;
      };
    };

    javaOverlay = final: prev: {
      jdk = final.${java};
      jre = final.${java};
    };

    scalaCliOverlay = final: prev: {
      scala-cli = prev.scala-cli.override {
        # hardcoded because scala-cli requires 17 or above
        # jre = pkgsForGraal.graalvm-ce;
        jre = final.${java};
      };
    };
  in [
    javaOverlay
    bloopOverlay
    scalaCliOverlay
    ammoniteOverlay
    millOverlay
  ];

  makePackages = java: let
    overlays = makeOverlays java;
  in
    import nixpkgs {
      inherit system overlays;
    };

  default = pkgs21;
  pkgs21 = makePackages "temurin-bin-21";
  # pkgs17 = makePackages "temurin-bin-17";
  # pkgs11 = makePackages "temurin-bin-11";
  # pkgs8 = makePackages "openjdk8";
in {
  inherit default pkgs21; # pkgs17 pkgs11 pkgs8;
}
