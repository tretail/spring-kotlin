module.exports = {
    // All imported modules in your tests should be mocked automatically
    // automock: false,

    // Stop running tests after `n` failures
    // bail: 0,

    // The directory where Jest should store its cached dependency information
    // cacheDirectory: "/private/var/folders/8l/thrm2b_50bb_dwhvx27p4xv80000gr/T/jest_e0",

    // Automatically clear mock calls and instances between every test
    clearMocks: true,
    testMatch: ["**/src/**/*.test.[jt]s?(x)"],
    coverageDirectory: 'coverage',
    testEnvironment: 'jsdom',
    preset: 'ts-jest',
    setupFilesAfterEnv: ['<rootDir>/src/setupTests.ts'],
    testPathIgnorePatterns: ['<rootDir>/node_modules/'],
    moduleNameMapper: {
        "\\.(pcss)$": "identity-obj-proxy",
    },
};