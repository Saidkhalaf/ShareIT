Feature: Reservation Pickup

  Als ontlener
  wil ik de lijst kunnen zien van alle reservaties die ik momenteel kan afhalen bij een uitlener
  zodat ik weet welke tools op dit moment beschikbaar zijn om op te halen

  Background:
    Given user
      | id | user_naam | address   | bankAccountNumber | email                | geoLocation | sharepoints |
      | 1  | Eveline   | Address 1 | BE123456789       | eveline@example.com  | null        | 1000        |
      | 2  | Albert    | 20        | BE123456789       | albert@exapmle.com   | null        | 20          |
      | 3  | Diederik  | Address 2 | BE987654321       | diederik@example.com | null        | 1000        |

    Given toolType
      | type               | guarantee |
      | Keukengereedschap  | 60        |
      | Tuingereedschap    | 50        |
      | Bouwgereedschap    | 40        |
      | Geluidsinstallatie | 400       |
      | Lichtinstallatie   | 150       |
      | Werkkleding        | 5         |

    Given tool
      | id | name               | type               | dayPrice | purchasePrice | current | owner    |
      | 1  | Kettingzaag        | Tuingereedschap    | 10       | 200           | 400     | Eveline  |
      | 2  | Zaagbroek          | Werkkleding        | 2        | 200           | 150     | Eveline  |
      | 3  | Veiligheidshelm    | Werkkleding        | 1        | 50            | 10      | Eveline  |
      | 4  | Kettingzaag2       | Tuingereedschap    | 10       | 200           | 400     | Eveline  |
      | 5  | Klopboormachine    | Bouwgereedschap    | 20       | 480           | 200     | Eveline  |
      | 6  | Keukenrobot        | Keukengereedschap  | 15       | 1000          | 1000    | Eveline  |
      | 7  | PA Seismic         | Geluidsinstallatie | 200      | 1000          | 90      | Diederik |
      | 8  | Black Strobo Magic | Lichtinstallatie   | 50       | 1000          | 90      | Diederik |

    Given toolSets
      | id | description | type            | owner   |
      | 9  | Zaagkit     | Tuingereedschap | Eveline |

    Given toolSetContent
      | set | tool |
      | 9   | 1    |
      | 9   | 2    |
      | 9   | 3    |

    Given reservation
      | reservation_id | tool            | borrower | lender  | startDate  | endDate    | status | duur |
      | Res1           | ZaagKit         | Diederik | Eveline | 15-12-2024 | 18-12-2024 | ACTIVE | 3    |
      | Res2           | Kettingzaag2    | Diederik | Eveline | 15-12-2024 | 19-12-2024 | ACTIVE | 4    |
      | Res3           | Keukenrobot     | Albert   | Eveline | 17-12-2024 | 19-12-2024 | ACTIVE | 2    |
      | Res4           | PA Seismic      | Albert   | Eveline | 15-12-2024 | 17-12-2024 | ACTIVE | 2    |
      | Res10          | PA Seismic      | Albert   | Eveline | 30-12-2024 | 01-01-2025 | ACTIVE | 2    |
      | Res20          | Klopboormachine | Albert   | Eveline | 21-12-2024 | 21-12-2019 | ACTIVE | 3    |


  Scenario: Toon af te halen gereedschap
    Given today is "15-12-2024"
    When "Eveline" aangeeft dat "Diederik" zijn reservaties wil ophalen
    Then wordt een lijst met 2 reservaties getoond
    And bevat de lijst "Res1"
    And bevat de lijst "Res2"

  Scenario: Ontlening met annulatie door aanbieder
    Given today is "15-12-2024"
    When "Eveline" aangeeft dat "Diederik" "Res1" wil ophalen
    And "Eveline" aangeeft dat "Eveline" "Res2" wil annuleren
    And "Eveline" bevestigt de afhaling
    Then wordt een afhalingtransactie aangemaakt
    And wordt een transactielijn gemaakt voor de ontlening van "Res1" met een prijs van 39 SP
    And wordt een transactielijn gemaakt voor de waarborg van "Res1" met een prijs van 50 SP
    And wordt een transactielijn gemaakt voor annulatie van "Res2" met een prijs van -4 SP
    And heeft "Diederik" 915 SP
    And heeft "Eveline" 1085 SP

  Scenario: Ontlening met annulatie door ontlener
    Given today is "15-12-2024"
    When "Eveline" aangeeft dat "Diederik" "Res1" wil ophalen
    And "Eveline" aangeeft dat "Diederik" "Res2" wil annuleren
    And "Eveline" bevestigt de afhaling
    Then wordt een afhalingtransactie aangemaakt
    And wordt een transactielijn gemaakt voor de ontlening van "Res1" met een prijs van 39 SP
    And wordt een transactielijn gemaakt voor de waarborg van "Res1" met een prijs van 50 SP
    And wordt een transactielijn gemaakt voor annulatie van "Res2" met een prijs van 4 SP
    And heeft "Diederik" 907 SP
    And heeft "Eveline" 1093 SP

  Scenario: Ontlening met onvoldoende puntensaldo
    Given today is "21-12-2019"
    When "Eveline" aangeeft dat "Albert" "Res20" wil ophalen
    And "Eveline" bevestigt de afhaling
    Then word er geen afhalingtransactie aangemaakt
    And is de status van de ontlening onveranderd
    And heeft "Albert" 20 SP
    And heeft "Eveline" 1000 SP