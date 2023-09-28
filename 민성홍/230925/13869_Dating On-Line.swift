//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/26.
////  백준 13869: Dating On-Line
////  메모리: 86524KB
////  시간: 56ms

import Foundation

let N: Int = Int(readLine()!)!
let angle: Double = 360.0 / Double(N)

func check() -> Double {
    var result: Double = 0
    var SN: [Double] = readLine()!.split(separator: " ").map { Double(String($0))! }
    SN = SN.sorted()

    switch N {
        case 3:
            result = (SN[0] * (SN[1] + SN[2]) + SN[1] * SN[2]) * sin((180.0 - angle) * Double.pi / 180)
            break

        case 4:
            result = ((SN[0] + SN.last!) * (SN[1] + SN[SN.count - 2]))
            break

        default:
            result += SN[0] * (SN[1] + SN[2])

            for i in 1..<(N - 2) {
                result += SN[i] * SN[i + 2]
            }

            result += SN[N - 1] * SN[N - 2]
            result = result * sin(angle * Double.pi / 180)
            break
    }

    return round(result / 2 * 10000) / 10000
}

print(String(format: "%.3f", check()))
